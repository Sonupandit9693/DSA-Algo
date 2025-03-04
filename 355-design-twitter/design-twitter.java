class Twitter {

    // inialize our timestamps
    private static int timestamps = 0;

    // user class to represent each user in twitter
    private class User{
        int id;
        Set<Integer> followed;
        Tweet tweetHead;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id); // user should follow themself 
            tweetHead = null;            
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            if(this.id != id){
                followed.remove(id);
            }
        }

        public void post(int id){
            Tweet newTweet = new Tweet(id);
            newTweet.next = tweetHead;
            tweetHead = newTweet;
        }
    }

    // tweet class represt to each tweet
    private class Tweet{
        int id;
        int time;
        Tweet next;

        public Tweet(int id){
            this.id = id;
            this.time = timestamps ++;
            next = null;
        }
    }


    private Map<Integer, User> userMap;

    // inialize our datastructures
    public Twitter() {
        userMap = new HashMap<>();
    }
    

    // compose a new tweet
    public void postTweet(int userId, int tweetId) {
        if(! userMap.containsKey(userId)){
            // create a new user
            User newUser = new User(userId);
            userMap.put(userId, newUser);
        }

        userMap.get(userId).post(tweetId);
    }
    

    // retrive 10 most recent tweet in the user's new feed
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newFeed = new LinkedList<>();
        if(! userMap.containsKey(userId)) return newFeed;

        Set<Integer> followedUser = userMap.get(userId).followed;
        PriorityQueue<Tweet> tweetHeap = new PriorityQueue<>(
            (a, b) -> b.time - a.time
        );

        for(int user: followedUser){
            Tweet tweet = userMap.get(user).tweetHead;
            if(tweet != null){
                tweetHeap.add(tweet);
            }
        }

        int count = 0;
        while(! tweetHeap.isEmpty() && count < 10){
            Tweet tweet = tweetHeap.poll();
            newFeed.add(tweet.id);
            count ++;
            if(tweet.next != null){
                tweetHeap.add(tweet.next);
            }
        }

        return newFeed;
    }

    // Follwer follow a followe
    public void follow(int followerId, int followeeId) {
        if(! userMap.containsKey(followerId)){
            User newUser = new User(followerId);
            userMap.put(followerId, newUser);
        }

        if(! userMap.containsKey(followeeId)){
            User newUser = new User(followeeId);
            userMap.put(followeeId, newUser);
        }

        userMap.get(followerId).follow(followeeId);
    }
    

    // followers unfollow a followee
    public void unfollow(int followerId, int followeeId) {
        if(userMap.containsKey(followerId) && followerId != followeeId){
            userMap.get(followerId).unfollow(followeeId);
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