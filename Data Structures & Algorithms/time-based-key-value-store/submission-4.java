class TimeMap {
    Map<List<String>, String> hm;
    Set<String> keys;
    Map<String, TreeSet<Integer>> keyToTime;

    public TimeMap() {
        keys = new HashSet<>();
        hm = new HashMap<>();
        keyToTime = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeSet<Integer> ts;

        if (keyToTime.containsKey(key)) {
            ts = keyToTime.get(key);
        } else {
            ts = new TreeSet<>();
        }

        ts.add(timestamp);
        keyToTime.put(key, ts);

        String timeStamp = timestamp + "";
        List<String> compoundKey = List.of(key, timeStamp);

        keys.add(key);
        hm.put(compoundKey, value);
    }

    public String get(String key, int timestamp) {
        if (!keys.contains(key)) {
            return "";
        }

        Integer localTimeStamp = keyToTime.get(key).floor(timestamp);

        String temp = localTimeStamp + "";
        List<String> compoundKey = List.of(key, temp);
        
        String ans = hm.get(compoundKey);

        return ans == null ? "" : ans;
    }
}
