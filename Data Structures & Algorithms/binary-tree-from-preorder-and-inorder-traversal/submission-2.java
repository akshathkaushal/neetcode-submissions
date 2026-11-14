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
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        int ilen = inorder.length;
        int plen = preorder.length;
        for(int i=0;i<ilen;i++) {
            inOrderMap.put(inorder[i],i);
        }

        return helper(preorder,0,plen-1,inorder,0,ilen-1,inOrderMap);
    }

    private TreeNode helper(int[] preOrder, int pStart, int pEnd,
    int[] inOrder, int iStart, int iEnd, 
    Map<Integer,Integer> inOrderMap) {

        if(pStart > pEnd || iStart > iEnd) return null;

        TreeNode root = new TreeNode(preOrder[pStart]);

        int pos = inOrderMap.get(root.val);
        int rem = pos-iStart;
        
        root.left = helper(preOrder,pStart+1,pStart+rem,inOrder,iStart,pos-1,inOrderMap);
        root.right = helper(preOrder,pStart+rem+1,pEnd,inOrder,pos+1,iEnd,inOrderMap);

        return root;
    }
}
