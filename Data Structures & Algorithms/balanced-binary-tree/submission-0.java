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
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBalanced;
    }

    private int helper(TreeNode root) {
        if(root == null) return 0;

        if(!isBalanced) return 0;

        int lft = helper(root.left);
        int rgt = helper(root.right);

        isBalanced &= (Math.abs(lft-rgt)<=1);

        return 1+Math.max(lft,rgt);
    }
}
