/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();

        sortedList = inOrder(root, sortedList);

        return sortedList.get(k-1);
    }

    private List<Integer> inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return List.of();
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);

        return list;
    }
}
