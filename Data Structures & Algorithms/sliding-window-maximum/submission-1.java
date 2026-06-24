class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // Dequeu stores indices. Font = index of max element in current window
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Rule 1 - Expire: remove indices outside the windown from the front 
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Rule 2 - Prune: remove the smaller elements from the back
            // Cause fact that: if it is older and smaller current element
            // Then there is no chance for it to become max in next window (expired before current)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Update current to right side of deque
            deque.offerLast(i);

            // Check current max in k window
            if (i >= k -1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
