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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int left = length(root.left);
        int right = length(root.right);
        int currDiameter = left + right;
        int leafDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(currDiameter, leafDiameter);
    }

    public int length(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(length(root.left), length(root.right));
    }
}
