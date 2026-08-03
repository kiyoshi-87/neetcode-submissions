class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int maxLength = 1;
        int L = 0;
        Set<Character> hs = new HashSet<>();
        hs.add(s.charAt(0));

        for (int R=1; R<s.length(); R++) {
            if (!hs.contains(s.charAt(R))) {
                hs.add(s.charAt(R));
                maxLength = Math.max(maxLength, R-L+1);
            } else {
                while(hs.contains(s.charAt(R))) {
                    hs.remove(s.charAt(L));
                    L++;
                }
                hs.add(s.charAt(R));
            }
        }

        return maxLength;
    }
}
