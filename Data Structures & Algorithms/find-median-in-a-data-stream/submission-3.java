class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> a-b);
        minHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        minHeap.add(num);
        if(minHeap.size()-maxHeap.size()>1 || 
        !maxHeap.isEmpty() && minHeap.peek() > maxHeap.peek()) {
            maxHeap.add(minHeap.poll());        
        } 

        if(maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (double) (minHeap.peek()+maxHeap.peek())/2;
        } else if(minHeap.size() > maxHeap.size()) {
            return (double) minHeap.peek();
        } else {
            return (double) maxHeap.peek();
        }
    }
}
