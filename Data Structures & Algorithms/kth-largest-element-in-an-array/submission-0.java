class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Naive/bruce force implement 
        // First we sorting the nums by desc
        // Then just pick the index k-1
        // Space complexity is O(1)
        // Time complexity O(log n) for sorting and O(k) for pick the answer
        // O(n)

        // Using min heap
        // Insert num into the heap
        // When the heap size is larger than the k
        // Pop the smallest out of the heap
        // Because the min heap sort element to ensure first alway smallest
        // Then with the heap size of k, the first one is k largest element

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
