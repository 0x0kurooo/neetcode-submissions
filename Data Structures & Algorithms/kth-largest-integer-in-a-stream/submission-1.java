class KthLargest {

    PriorityQueue heap = new PriorityQueue<>();
    int size;

    public KthLargest(int k, int[] nums) {
        for (int num : nums) {
            heap.offer(num);
        }
        size = k;
    }
    
    public int add(int val) {
        heap.offer(val);
        while (heap.size() > size) {
            heap.poll();
        }
        return (int) heap.peek();
    }
}
