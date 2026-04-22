class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            List<List<Integer>> next = new ArrayList<>();

            for (List<Integer> list : ans) {
                for (int i=0; i<=list.size(); i++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(i, num);
                    next.add(newList);
                }
            }
            ans = next;
        }
        
        return ans;
    }
}