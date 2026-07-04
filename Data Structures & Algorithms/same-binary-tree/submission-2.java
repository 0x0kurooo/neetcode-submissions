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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[]{p, q});

        while (!queue.isEmpty()) {
            TreeNode[] pair = queue.poll();
            TreeNode node1 = pair[0], node2 = pair[1];

            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;

            queue.offer(new TreeNode[]{node1.left, node2.left});
            queue.offer(new TreeNode[]{node1.right, node2.right});
        }

        return true;
    }
}
