class Twitter {
    // Need to store user's tweet first
    Map<Integer, List<Integer>> userTweets = new HashMap<>();
    // Store user followees
    Map<Integer, Set<Integer>> userFollowees = new HashMap<>();
    // Store timestamp order of tweets
    Map<Integer, Integer> tweetTime = new HashMap<>();
    int timestamp = 0;

    public Twitter() {
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Integer> tweets = userTweets.computeIfAbsent(userId, k -> new ArrayList<Integer>());
        tweets.add(tweetId);
        tweetTime.put(tweetId, timestamp);
        timestamp++;
    }

    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> newsfeed = new PriorityQueue<>((a, b) -> tweetTime.get(b) - tweetTime.get(a));
        List<Integer> tweets = userTweets.computeIfAbsent(userId, k -> new ArrayList<Integer>());
        for (int tweet : tweets) {
            newsfeed.offer(tweet);
        }

        Set<Integer> followees = userFollowees.computeIfAbsent(userId, k -> new HashSet<>());
        for (int followee : followees) {
            if (followee == userId) continue;
            List<Integer> followeeTweets = userTweets.computeIfAbsent(followee, k -> new ArrayList<Integer>());
            for (int tweet : followeeTweets) {
                newsfeed.offer(tweet);
            }
        }

        List<Integer> news = new ArrayList<>();
        while (!newsfeed.isEmpty() && news.size() < 10) {
            news.add(newsfeed.poll());
        }
        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = userFollowees.computeIfAbsent(followerId, k -> new HashSet<>());
        followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userFollowees.computeIfAbsent(followerId, k -> new HashSet<>());
        followees.remove(followeeId);
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