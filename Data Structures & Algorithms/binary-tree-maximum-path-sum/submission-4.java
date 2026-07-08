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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int sum = root.val + Math.max(leftSum, 0) + Math.max(rightSum, 0);

        // We can have 3 cases:
        // - Max path go through the root
        // - Max path on the left node
        // - Max path on the right node

        if (root.left != null) {
            int maxLeft = maxPathSum(root.left);
            sum = Math.max(sum, maxLeft);
        }
        if (root.right != null) {
            int maxRight = maxPathSum(root.right);
            sum = Math.max(sum, maxRight);
        }
        
        return sum;
    }

    // Return max sum with root
    public int sum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(sum(root.left), 0);
        int right = Math.max(sum(root.right), 0);
        return Math.max(left, right) + root.val;        
    }
}
