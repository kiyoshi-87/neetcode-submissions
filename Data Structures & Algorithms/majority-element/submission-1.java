class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int majorityValue = nums.length/2;

        for (int num: nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);

            if (hm.get(num) > majorityValue) {
                return num;
            }
        }
        return -1;

    }
}