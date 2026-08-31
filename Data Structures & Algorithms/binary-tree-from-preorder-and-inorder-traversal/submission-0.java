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
    int preIdx=0;
    int inIdx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder, Integer.MAX_VALUE);
    }
    private TreeNode dfs(int[] pre, int[] in, int limit) {
        if(preIdx >= pre.length) return null;
        if(in[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(pre[preIdx++]);
        root.left = dfs(pre,in,root.val);
        root.right = dfs(pre,in,limit);
        return root;
    }
}
