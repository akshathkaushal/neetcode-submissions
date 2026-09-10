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
    private int res;
    public int maxPathSum(TreeNode root) {
        if(root != null) res = root.val;
        helper(root);
        return res;
    }
    private int helper(TreeNode root) {
        if(root==null) return 0;

        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));

        res = Math.max(res,root.val+left+right);
        return root.val + Math.max(left,right);
    }
}
