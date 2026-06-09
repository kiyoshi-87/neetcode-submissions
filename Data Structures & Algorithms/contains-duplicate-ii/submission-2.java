class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }

        Set<Integer> hs = new HashSet<>();

        int l = 0;

        for (int r=0; r<nums.length; r++) {
            if (r-l > k) {
                hs.remove(nums[l]);
                l++;
            }

            if (hs.contains(nums[r])) {
                return true;
            }
            
            hs.add(nums[r]);
        }

        return false;
    }
}