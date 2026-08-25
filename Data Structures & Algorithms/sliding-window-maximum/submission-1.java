class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> que = new ArrayDeque<>();
        int l=0, r=0;
        while(r<n) {
            while(!que.isEmpty() && nums[que.getLast()] < nums[r]) {
                que.removeLast();
            }
            que.addLast(r);

            if(l > que.getFirst()) {
                que.removeFirst();
            }

            if(r+1 >= k) {
                res[l] = nums[que.getFirst()];
                l++;
            }

            r++;
        }

        return res;
    }
}
