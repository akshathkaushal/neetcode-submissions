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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> nodeMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            nodeMap.put(inorder[i],i);
        }

        TreeNode root = buildTree(
            preorder,0,preorder.length-1,
            inorder,0,inorder.length-1,
            nodeMap);

        return root;
    }
    private TreeNode buildTree(
        int[] preorder, int pStart, int pEnd,
        int[] inorder, int iStart, int iEnd,
        Map<Integer,Integer> nodeMap) {

            if(pStart>pEnd || iStart>iEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[pStart]);

            int rootLocInorder = nodeMap.get(root.val);
            int numsOnLeft = rootLocInorder-iStart;

            root.left = buildTree(preorder,pStart+1,pStart+numsOnLeft,
            inorder,iStart,rootLocInorder-1, nodeMap);
            root.right = buildTree(preorder,pStart+numsOnLeft+1,pEnd,
            inorder,rootLocInorder+1,iEnd,nodeMap);

            return root;
        }
}
