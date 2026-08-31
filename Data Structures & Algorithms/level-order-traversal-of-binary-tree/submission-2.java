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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) que.add(root);

        while(!que.isEmpty()) {
            int size = que.size();
            res.add(new ArrayList<>());

            for(int i=0;i<size;i++) {
                TreeNode qTop = que.poll();
                res.getLast().add(qTop.val);

                if(qTop.left != null) que.add(qTop.left);
                if(qTop.right != null) que.add(qTop.right);
            }
        }

        return res;
    }
}
