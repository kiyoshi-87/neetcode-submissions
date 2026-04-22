class Solution {
    Set<List<Integer>> ans = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(0, target, candidates, 0, new ArrayList<>());

        return ans.stream()
        .toList();
        
    }

    private void helper(int i, int target, int[] nums, int sum, List<Integer> subset) {
        if (sum == target) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        if (sum > target || i == nums.length) {
            return;
        }

        // Include nums[i]
        subset.add(nums[i]);
        helper(i+1, target, nums, sum + nums[i], subset);
        subset.removeLast();

        // Skip nums[i] and all following duplicates to prune the tree
        while (i + 1 < nums.length && nums[i] == nums[i + 1])
        {
            i++;
        }
        helper(i + 1, target, nums, sum, subset);
    }
}
