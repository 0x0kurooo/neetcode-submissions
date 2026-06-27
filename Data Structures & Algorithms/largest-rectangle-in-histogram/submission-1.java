class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // Sentinal 0 at the end forces all remaining bars to pop
        // at the end without flush loop
        int[] h = Arrays.copyOf(heights, n + 1);

        // Stack to store indices not heights
        // bottom -> smallest top -> largest
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            // Current bar is shorter than stack top
            // -> stack top found the boundary
            // Pop and calculate rectangle
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];

                // Left boundary = new stack after pop
                // If stack empty we use all elements from the left side
                // -> Left boundary = -1

                int left = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, height * (i - left - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}
