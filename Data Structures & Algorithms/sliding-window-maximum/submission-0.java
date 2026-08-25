class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int i=0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int j=0;j<k;j++) {
            que.add(nums[j]);
        }
        res[i++] = que.peek();
        for(int j=k;j<nums.length;j++) {
            que.remove(nums[j-k]);
            que.add(nums[j]);
            res[i++] = que.peek();
        }
        return res;
    }
}
