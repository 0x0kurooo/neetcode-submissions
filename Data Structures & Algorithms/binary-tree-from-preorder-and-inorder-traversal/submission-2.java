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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        
        // Split in-order to 2 parts left and right
        int mid = 0;
        for (int i = 0; i < inorder.length; i ++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        int[] left = Arrays.copyOfRange(inorder, 0, mid);
        int[] right = Arrays.copyOfRange(inorder, mid + 1, inorder.length);

        // Split pre-oprder to 2 part left and right
        int[] leftPre = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

        root.left = buildTree(leftPre, left);
        root.right = buildTree(rightPre, right);
        
        return root;
    }
}
