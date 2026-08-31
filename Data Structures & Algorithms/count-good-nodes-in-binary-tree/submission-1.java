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
    public int goodNodes(TreeNode root) {
        res=0;
        helper(root,-101);
        return res;
    }
    private void helper(TreeNode root, int maxVal) {
        if(root == null) return;

        if(root.val >= maxVal) {
            res++;
            maxVal=root.val;
        }

        helper(root.left,maxVal);
        helper(root.right,maxVal);
    }
}
