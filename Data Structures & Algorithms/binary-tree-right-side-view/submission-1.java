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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que = new ArrayDeque<>();
        if(root != null) que.add(root);

        List<Integer> res = new ArrayList<>();

        while(!que.isEmpty()) {
            int size = que.size();

            for(int i=0;i<size;i++) {
                TreeNode qTop = que.poll();
                if(i==size-1) res.add(qTop.val);

                if(qTop.left != null) que.add(qTop.left);
                if(qTop.right != null) que.add(qTop.right);
            }
        }

        return res;
    }
}
