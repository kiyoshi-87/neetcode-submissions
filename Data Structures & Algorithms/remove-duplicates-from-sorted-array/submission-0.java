class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        
        int count = 0;
        int l = 0;

        for (int r=1; r<nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[l+1] = nums[r];
                l++;
                count++;
            }
        }

        return count+1;
    }
}