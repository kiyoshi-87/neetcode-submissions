class Twitter {
    Map<Integer, List<Integer>> hm;
    Stack<List<Integer>> st;

    public Twitter() {
        hm = new HashMap<>();
        st = new Stack<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<Integer> pair = new ArrayList<>();
        pair.add(userId);
        pair.add(tweetId);

        st.add(pair);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<List<Integer>> temp = st.stream().toList();
        List<Integer> ans = new ArrayList<>();
        List<Integer> followeeList = hm.getOrDefault(userId, new ArrayList<>());
        
        int counter = 0;
        for (int i = temp.size() - 1; i >= 0; i--) {
            List<Integer> pair = temp.get(i);
            int followeeId = pair.get(0);
            
            if (followeeList.contains(followeeId) || userId == followeeId) {
                ans.add(pair.get(1));
                counter++;
            }
            
            if (counter == 10) {
                break;
            }
        }
        
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) 
            return;
        
        List<Integer> followeeList = hm.getOrDefault(followerId, new ArrayList<>());

        if (!followeeList.contains(followeeId)) {
            followeeList.add(followeeId);
        }

        hm.put(followerId, followeeList);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followeeList = hm.get(followerId);

        if (followeeList != null) {
            followeeList.remove(Integer.valueOf(followeeId));
        }
    }
}