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
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left, 1);
        int rightHeight = getHeight(root.right, 1);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
        }
    

    private int getHeight(TreeNode root, int level) {
        if (root == null) {
            return level;
        }

        level++;

        int leftHeight = getHeight(root.left, level);
        int rightHeight = getHeight(root.right, level);

        return Math.max(leftHeight, rightHeight);
    }
}
