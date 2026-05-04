class Solution {
    Map<String, List<String>> hm = new HashMap<>();
    Map<List<String>, String> hm2 = new HashMap<>();

    public String encode(List<String> strs) {
        if (hm2.containsKey(strs)) {
            return hm2.get(strs);
        }

        String randomString = UUID.randomUUID().toString();
        hm.put(randomString, strs);
        hm2.put(strs, randomString);

        return randomString;
    }

    public List<String> decode(String str) {
        return hm.get(str);
    }
}
