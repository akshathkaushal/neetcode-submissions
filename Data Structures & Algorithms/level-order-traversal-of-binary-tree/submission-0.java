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
        List<List<Integer>> levelOrder = new ArrayList<>();
        helper(root,0,levelOrder);
        return levelOrder;
    }
    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if(root==null) {
            return;
        }

        if(level==res.size()) res.add(new ArrayList<>());

        res.get(level).add(root.val);
        helper(root.left,level+1,res);
        helper(root.right,level+1,res);
    }
}
