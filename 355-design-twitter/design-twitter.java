class Twitter {
    // Map to store user tweets: userId -> list of [tweetId, timestamp]
    private Map<Integer, List<int[]>> tweets;
    // Map to store follow relationships: followerId -> set of followeeIds
    private Map<Integer, Set<Integer>> following;
    // Global timestamp for ordering tweets
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        // If user doesn't exist, create new list
        tweets.putIfAbsent(userId, new ArrayList<>());
        // Add tweet with current timestamp
        tweets.get(userId).add(new int[]{tweetId, timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Priority queue to get most recent tweets (max heap based on timestamp)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            pq.addAll(tweets.get(userId));
        }
        
        // Add tweets from followed users
        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                pq.addAll(tweets.get(followeeId));
            }
        }
        
        // Get 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            newsFeed.add(pq.poll()[0]);
            count++;
        }
        
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        // If follower doesn't exist, create new set
        following.putIfAbsent(followerId, new HashSet<>());
        // Add followee to follower's set
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        // Remove followee from follower's set if it exists
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */