class MedianFinder {
    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

    public MedianFinder() {
    }
    
    public void addNum(int num) {
        // Idea keep two sorted left and right
        // If new num > smallest from the right
        // Add to right and poll the smallest to left
        // If the num < bigest of the left, insert to left and move the bigest to right
        // Edgecase: init state and insert the first num
        if (leftHeap.isEmpty() || num < leftHeap.peek()) {
            leftHeap.offer(num);
        } else {
            rightHeap.offer(num);
        }

        if (leftHeap.size() > rightHeap.size() + 1) {
            rightHeap.offer(leftHeap.poll());
        } else if (rightHeap.size() > leftHeap.size() + 1) {
            leftHeap.offer(rightHeap.poll());
        }
    }
    
    public double findMedian() {
        if (rightHeap.size() == leftHeap.size()) {
            return ((double) rightHeap.peek() + leftHeap.peek()) / 2;
        }

        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        } else {
            return rightHeap.peek();
        }
    }
}
