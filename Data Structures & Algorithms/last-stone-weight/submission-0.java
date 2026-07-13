class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int stone : stones) {
            maxHeap.offer(-stone);
        }

        while (!maxHeap.isEmpty()) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            int left = Math.abs(first - second);
            if (maxHeap.isEmpty()) {
                return left;
            }
            maxHeap.offer(-left);
        }

        return -1;
    }
}
