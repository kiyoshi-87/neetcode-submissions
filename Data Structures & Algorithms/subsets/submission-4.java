class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0, new ArrayList<>());

        return list;
    }

    private void helper(List<List<Integer>> list, int[] nums, int index, List<Integer> subset) {
        if (index >= nums.length) {
            list.add(new ArrayList<>(subset));
            return;
        }

        // add element of index
        subset.add(nums[index]);
        helper(list, nums, index+1, subset);
        subset.remove(subset.size() - 1);

        // skip element of index
        helper(list, nums, index+1, subset);
    }
}
