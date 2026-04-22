class Solution {
    private Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        helper(0, nums, new ArrayList<>());

        return ans.stream().toList();
    }

    private void helper(int i, int[] nums, List<Integer> subset) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(subset.stream().sorted().toList()));
            return;
        }

        // add ith element to list
        subset.add(nums[i]);
        helper(i + 1, nums, subset);
        subset.removeLast();

        // skip ith element
        helper(i + 1, nums, subset);
    }
}
