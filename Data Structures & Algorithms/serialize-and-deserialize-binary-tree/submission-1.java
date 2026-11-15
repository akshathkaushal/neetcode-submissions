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
        if(root == null) return "";
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        StringBuilder str = new StringBuilder();

        while(!que.isEmpty()) {
            TreeNode qTop = que.poll();
            if(qTop == null) {
                str.append("#").append(",");
                continue;
            }
            str.append(qTop.val).append(",");
            que.add(qTop.left);
            que.add(qTop.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        String[] nodes = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        que.add(root);
        for(int i=1;i<nodes.length;i++) {
            TreeNode parent = que.poll();
            if(!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                que.add(left);
            }
            i++;
            if(!nodes[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                que.add(right);
            }
        }
        return root;
    }
}
