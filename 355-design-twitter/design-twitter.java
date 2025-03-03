class Twitter {
    private static final int FEED_SIZE = 10;
    private Map<Integer, LinkedList<int[]>> tweets;
    private Map<Integer, Set<Integer>> following;
    private int timestamp;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new LinkedList<>());
        LinkedList<int[]> userTweets = tweets.get(userId);
        userTweets.addFirst(new int[]{tweetId, timestamp++});
        if (userTweets.size() > FEED_SIZE) {
            userTweets.removeLast();
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        // Use a min-heap based on timestamp (most recent first)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        
        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            heap.addAll(tweets.get(userId));
        }
        
        // Add tweets from followed users
        Set<Integer> followees = following.getOrDefault(userId, new HashSet<>());
        for (int followeeId : followees) {
            if (tweets.containsKey(followeeId)) {
                heap.addAll(tweets.get(followeeId));
            }
        }
        
        // Get up to 10 most recent tweets
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty() && result.size() < FEED_SIZE) {
            result.add(heap.poll()[0]);
        }
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        following.putIfAbsent(followerId, new HashSet<>());
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
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