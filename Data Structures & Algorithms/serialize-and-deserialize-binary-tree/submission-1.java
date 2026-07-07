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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> tree = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                tree.add("null");
                continue;
            }
            
            tree.add(String.valueOf(curr.val));
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return String.join(",", tree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < nodes.length) {
            TreeNode curr = queue.poll();

            // Get left and right node
            String left = nodes[idx];
            String right = nodes[idx + 1];
            idx += 2;

            curr.left = !left.equals("null") ? new TreeNode(Integer.parseInt(left)) : null;
            curr.right = !right.equals("null") ? new TreeNode(Integer.parseInt(right)) : null;
            
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return root;
    }
}
