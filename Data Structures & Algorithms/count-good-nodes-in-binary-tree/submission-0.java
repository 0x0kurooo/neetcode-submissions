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
    int count = 0;
    public int goodNodes(TreeNode root) {
        // We can do the dfs start from the root
        // For each node, we have track the max of node value in the current path
        // If the node is >= the max in path then increase the count
        // Then call dfs for child nodes with max(node val, max)
        dfs(root, -100);
        return count;
    }

    public void dfs(TreeNode node, int pathMax) {
        if (node == null) return;
        if (node.val >= pathMax) {
            count ++;
            pathMax = node.val;
        }
        dfs(node.left, pathMax);
        dfs(node.right, pathMax);
    }
}
