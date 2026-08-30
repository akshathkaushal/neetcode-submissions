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
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
    private int helper(TreeNode root) {
        if(root == null) return 0;

        int lft = helper(root.left);
        int rgt = helper(root.right);

        diameter = Math.max(diameter,lft+rgt);
        return 1+Math.max(lft,rgt);
    }
}
