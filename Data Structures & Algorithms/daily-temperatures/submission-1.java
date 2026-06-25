class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i --) {
            while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peek()]) {
                deque.poll();
            }
            
            if (deque.isEmpty()) {
                ans[i] = 0;
            } else {
                int prev = deque.peek();
                ans[i] = prev - i;
            }
            
            deque.push(i);
        }

        return ans;
    }
}
