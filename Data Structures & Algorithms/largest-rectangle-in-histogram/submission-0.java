class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            // For each bar, try to expand to the right until meet the lower bar
            int area = heights[i];
            int minHeight = heights[i];
            int right = i + 1;

            while (right < n && heights[right] >= minHeight) {
                area += minHeight;
                right ++;
            }
            
            int left = i - 1;
            while (left >= 0 && heights[left] >= minHeight) {
                area += minHeight;
                left --;
            }

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
