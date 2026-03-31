class Solution {
    public int findDuplicate(int[] nums) {
        int[] markerList = new int[nums.length+1];

        for (int i = 0; i<markerList.length; i++) {
            if (markerList[nums[i]] != 0) {
                return nums[i];
            } 

            markerList[nums[i]] = -1;
        }

        return -1;
    }
}
