class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String str : strs) {
            checkAnagramAndAddInMap(str, hm);
        }

        List<List<String>> ans = new ArrayList<>();

        for (String key : hm.keySet()) {
            ans.add(hm.get(key));
        }

        return ans;
    }

    private void checkAnagramAndAddInMap(String str, HashMap<String, List<String>> hm) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        String sortedStr = new String(chars);

        if (!hm.containsKey(sortedStr)) {
            List<String> temp = new ArrayList<>();
            temp.add(str);
            hm.put(sortedStr, temp);
        } else {
            List<String> list = hm.get(sortedStr);
            
                list.add(str);
                hm.put(sortedStr, list);
            
        }
    }
}
