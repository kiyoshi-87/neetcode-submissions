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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return Collections.emptyList();
        }
        if (root != null) {
            ans.add(List.of(root.val));
        }

        insertIntoQueue(root, queue);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                insertIntoQueue(node, queue);
                list.add(node.val);
            }

            ans.add(list);
        }

        return ans;
    }

    private void insertIntoQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node.left != null) {
            queue.offer(node.left);
        }

        if (node.right != null) {
             queue.offer(node.right);
        }
    }
}
