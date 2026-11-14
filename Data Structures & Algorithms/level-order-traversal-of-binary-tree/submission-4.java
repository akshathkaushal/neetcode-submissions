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
        Queue<TreeNode> que = new ArrayDeque<>();
        if(root != null) que.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!que.isEmpty()) {
            int sz = que.size();
            res.add(new ArrayList<>());
            for(int i=0;i<sz;i++) {
                TreeNode node = que.poll();
                res.get(res.size()-1).add(node.val);
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }

        return res;
    }
}
