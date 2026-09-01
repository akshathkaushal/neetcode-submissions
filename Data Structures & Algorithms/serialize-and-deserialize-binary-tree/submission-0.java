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
        List<String> res = new ArrayList<>();
        serializeHelper(root,res);
        return String.join(",",res);
    }
    private void serializeHelper(TreeNode root, List<String> res) {
        if(root==null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        serializeHelper(root.left,res);
        serializeHelper(root.right,res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return deserializeHelper(nodes);
    }
    private Integer idx=0;
    private TreeNode deserializeHelper(String[] data) {
        if(data[idx].equals("N")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        root.left = deserializeHelper(data);
        root.right = deserializeHelper(data);
        return root;
    }

}
