class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Use min heap for store distance -> need keep the list 
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        
        for (int[] p : points) {
            heap.offer(p);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i ++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
