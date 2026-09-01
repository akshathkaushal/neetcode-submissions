class KthLargest {
    private PriorityQueue<Integer> que;
    private Integer maxSize;
    public KthLargest(int k, int[] nums) {
        que = new PriorityQueue<Integer>();
        maxSize=k;

        for(int n : nums) {
            que.add(n);
            if(que.size()>k) que.poll();
        }
    }
    
    public int add(int val) {
        if(que.size()<maxSize) {
            que.add(val);
            return que.peek();
        }
        que.add(val);
        que.poll();
        return que.peek();
    }
}
