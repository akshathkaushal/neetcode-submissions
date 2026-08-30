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

        if(compareTree(root,subRoot)) {
            return true;
        } 
        return 
        isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
    }
    private boolean compareTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        else if(p==null || q==null ||p.val!=q.val) return false;

        return (p.val==q.val) &&
        compareTree(p.left,q.left) &&
        compareTree(p.right,q.right);
    }
}
