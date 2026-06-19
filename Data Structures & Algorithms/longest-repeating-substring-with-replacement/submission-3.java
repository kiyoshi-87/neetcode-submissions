class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int ans = 0;

        Map<Character, Integer> hm = new HashMap<>();

        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            
            int windowSize = r-l+1;
            int freq = getFrequencyOfMostOccuringCharacter(hm);

            while (windowSize - freq > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;

                freq = getFrequencyOfMostOccuringCharacter(hm);
                windowSize = r-l+1;
            }

            ans = Math.max(ans, windowSize);
            r++;
        }

        return ans;
    }

    private static int getFrequencyOfMostOccuringCharacter(Map<Character, Integer> hm) {
        int max = 0;

        for (Map.Entry<Character, Integer> me : hm.entrySet()) {
            max = Math.max(max, me.getValue());
        }

        return max;
    }
}
