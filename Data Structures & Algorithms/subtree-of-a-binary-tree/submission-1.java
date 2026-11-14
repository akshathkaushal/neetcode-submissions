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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        if(compareTree(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    private boolean compareTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        else if(t1 == null || t2 == null) return false;

        return (t1.val == t2.val) && compareTree(t1.left,t2.left) && compareTree(t1.right,t2.right);
    }
}
