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
    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return depth;
        }

        if (root.left == null && root.right==null) {
            return depth + 1;
        }

        int level = depth;
        return getDepth(root, level);
    }

    private int getDepth(TreeNode root, int level) {
        if (root == null) {
            return -1;
        }

        level++;

        int leftDepth = getDepth(root.left, level);
        int rightDepth = getDepth(root.right, level);

        depth = Math.max(leftDepth, rightDepth);
        return Math.max(depth, level);
    }
}
