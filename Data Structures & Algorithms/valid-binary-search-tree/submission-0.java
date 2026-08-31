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
    private boolean res;
    public boolean isValidBST(TreeNode root) {
        res = true;
        helper(root);
        return res;
    }
    // {min value, max value}
    private int[] helper(TreeNode root) {
        if(root == null) return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE};
        if(!res) return new int[]{0,0};

        int[] leftP = helper(root.left);
        int[] rightP = helper(root.right);

        if(root.val <= leftP[1] || root.val >= rightP[0]) res = false;

        return new int[]{Math.min(leftP[0], root.val), Math.max(rightP[1], root.val)};
    }
}
