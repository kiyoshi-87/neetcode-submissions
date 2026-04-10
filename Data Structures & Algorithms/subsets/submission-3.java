class Solution {
    // Backtracking solution
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        helper(0, nums, new ArrayList<>());

        return ans;
    }

    private void helper(int i, int[] nums, List<Integer> currSet) {
        if (i >= nums.length) {
            ans.add(new ArrayList<>(currSet));
            return;
        }

        // Condition #1 we add i to currSet
        currSet.add(nums[i]);
        helper(i+1, nums, currSet);
        currSet.remove(currSet.size() - 1);  // Removing nums[i] in this set

        // Condition #2 we don't add nums[i] to currSet
        helper(i+1, nums, currSet);
    }
}