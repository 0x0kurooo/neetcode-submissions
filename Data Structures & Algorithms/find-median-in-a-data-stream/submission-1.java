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
        if (leftHeap.isEmpty()) {
            leftHeap.offer(num);
            return;
        }

        int maxLeft = leftHeap.peek();
        if (num < maxLeft) {
            leftHeap.offer(num);
            if (leftHeap.size() > rightHeap.size()) {
                rightHeap.offer(leftHeap.poll());
            }
            System.out.println("add left: " + num);
        } else {
            rightHeap.offer(num);
            if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }
            System.out.println("add right: " + num);
        }

        System.out.println(leftHeap);
        System.out.println(rightHeap);
    }
    
    public double findMedian() {
        if (rightHeap.size() == leftHeap.size()) {
            return (double) (rightHeap.peek() + leftHeap.peek()) / 2;
        }

        if (leftHeap.size() > rightHeap.size()) {
            return leftHeap.peek();
        } else {
            return rightHeap.peek();
        }
    }
}
