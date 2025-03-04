class MedianFinder {

    private PriorityQueue<Integer> minHeap; // Stores the larger half of the numbers
    private PriorityQueue<Integer> maxHeap; // Stores the smaller half of the numbers

    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // Min-heap (default behavior in Java)
        maxHeap = new PriorityQueue<>((a ,b) -> b - a); // Max-heap
    }
    
    public void addNum(int num) {
        // Add to maxHeap first
        maxHeap.offer(num);
        
        // Ensure maxHeap's max is not greater than minHeap's min
        minHeap.offer(maxHeap.poll());
        
        // Balance sizes: maxHeap can have at most one more element than minHeap
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */