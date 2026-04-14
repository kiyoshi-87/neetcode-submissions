class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(0, target, nums, 0, new ArrayList<>());

        return ans;
    }

    private void helper(int i, int target, int[] nums, int sum, List<Integer> subset) {
        if (sum == target) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        if (sum > target || i == nums.length) {
            return;
        }

        // Include nums[i] and stay at index i (unlimited usage)
        subset.add(nums[i]);
        helper(i, target, nums, sum + nums[i], subset);
        subset.remove(subset.size() - 1);

        // Skip nums[i] and move to index i + 1
        helper(i + 1, target, nums, sum, subset);
    }
}