class Solution {
    public int maxSubArray(int[] nums) {
        // Kadane's Algo
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0; 

        for (int num : nums) {
            currSum = Math.max(0, currSum);
            
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
        }

        return maxSum;
    }
}
