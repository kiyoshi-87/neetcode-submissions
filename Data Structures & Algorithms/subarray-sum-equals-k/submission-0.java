class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int count = 0;

        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        for (int i=0; i<nums.length; i++) {
            if (i > 0) {
                prefixSum[i] = nums[i] + prefixSum[i-1];
            }
            int sum = prefixSum[i] - k;

            if (hm.containsKey(sum)) {
                count += hm.get(sum);
            }
            
            hm.put(prefixSum[i], hm.getOrDefault(prefixSum[i], 0) + 1);
        }

        return count;
    }
}