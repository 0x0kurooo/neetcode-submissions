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
    List<List<Integer>> nodes = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return nodes;
        };
        
        helper(root, 0);
        return nodes;
    }

    public void helper(TreeNode root, int level) {
        if (root == null) return;

        if (this.nodes.size() - 1 < level) {
            this.nodes.add(new ArrayList<Integer>());
        }
        List<Integer> elements = this.nodes.get(level);
        elements.add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
