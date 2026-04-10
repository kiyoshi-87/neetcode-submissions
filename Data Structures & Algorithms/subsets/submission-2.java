class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*
            1. For eg consider this: [1, 2, 3]
            2. In the first for loop the array ans contains only this: [[]]
            3. First iteration num = 1, size = 1
            4. Second loop inside first, subset = [].
            5. Subset updated to [1].
            6. ans updated to [[], [1]].
            7. First inside loop done also num = 1 loop also done.
            8. 2nd iteration: num = 2, size = 2
            9. First iteration of the 2nd loop, subset = []
            10. subset updated to [2].
            11. ans updated to [[], [1], [2]].
            12. 2nd iteration of the 2nd loop, subset = [1]
            13. subset updated to [1, 2]
            14. ans updated to [[], [1], [2], [1, 2]].
            15. Loop done similar thing with num = 3.
            
            NOTE: Loop only goes to the size of the ans array, so until the previous subArray.
        */

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());

        for (int num : nums) {
            int size = ans.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(ans.get(i));
                subset.add(num); // adding into the previous subset...
                ans.add(subset); // adding this new subset...
            }
        }

        return ans;
    }
}