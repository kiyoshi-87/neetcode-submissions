class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) {
            return List.of(nums[0]);
        }

        if (nums.length == 2) {
            return List.of(nums[0], nums[1]);
        }

        List<Integer> ans = new ArrayList<>();

        Map<Integer, Integer> hm = new HashMap<>();

        for (int i : nums) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        float occ = (nums.length)/3;

        for (int i: hm.keySet()) {
            if (hm.get(i) > occ) {
                ans.add(i);
            }
        }

        return ans;
    }
}