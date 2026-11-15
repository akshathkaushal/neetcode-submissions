class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minHeap.add(num);

        if(minHeap.size() > maxHeap.size()+1) {
            maxHeap.add(minHeap.poll());
        }

        if(!maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            int small = minHeap.poll();
            int large = maxHeap.poll();
            minHeap.add(large);
            maxHeap.add(small);
        }
    }
    
    public double findMedian() {
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();

        double ans = (minHeap.peek()+maxHeap.peek())/2.0;
        return ans;
    }
}
