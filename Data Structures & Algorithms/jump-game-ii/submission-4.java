class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        

        int index = 0;
        int count = 0;

        while (index != nums.length - 1) {
            int jumps = nums[index]; // 2
            int big = -1;

            if (index + jumps >= nums.length-1) {
                count++;
                break;
            }

            int jumpsAllowed = index+jumps;
            int nextIndex = index;

            for (int i=index+1; i<= jumpsAllowed; i++) {
                if (i<nums.length && i + nums[i] >= big) {
                    nextIndex = i;
                    big = i + nums[i];
                }
            }

            index = nextIndex;
            count++;
        }

        return count;
    }
}