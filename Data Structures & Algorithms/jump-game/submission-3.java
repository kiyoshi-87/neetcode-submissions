class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        if (nums[0] == 0) {
            return false;
        }

        int currIndex = nums.length - 1;

        boolean isValid = false;

        for (int i=currIndex-1; i>=0; i--) {
            if (nums[i] == 0) {
                continue;
            }

            int diff = currIndex - i;

            if (diff<=nums[i]) {
                currIndex = i;
            } else {
                if (i<=0) {
                    return isValid;
                }
                continue;
            }
        }

        isValid = true;

        return isValid;
    }
}
