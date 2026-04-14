class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        helper(1, n, k, new ArrayList<>());

        return ans;
    }

    private void helper(int i, int n, int k, List<Integer> subset) {
        if (subset.size() == k) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        if (i == n+1) {
            return;
        }

        // Include i
        subset.add(i);
        helper(i+1, n, k, subset);
        subset.remove(subset.size() - 1);

        // Do not include i
        helper(i+1, n, k, subset);
    }
}