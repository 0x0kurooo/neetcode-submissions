class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < k-1; i++) {
            queue.offer(nums[i]);
        }
        int left = 0, right = k-1;

        List<Integer> ans = new ArrayList<>();
        while (right < nums.length) {
            queue.offer(nums[right]);
            ans.add(queue.peek());
            queue.remove(nums[left]);
            left++;
            right++;
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
