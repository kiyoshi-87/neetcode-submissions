class NumArray {
    int[] nums;
    int[] prefixSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        populatePrefixSum(nums);
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSum[right];
        }
        
        return prefixSum[right] - prefixSum[left-1];
    }

    private void populatePrefixSum(int[] nums) {
        prefixSum = new int[nums.length];
        if (nums.length == 1) {
            prefixSum = nums;
        }

        prefixSum[0] = nums[0];
        int previousSum = prefixSum[0];
        for (int i=1; i<nums.length; i++) {
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */