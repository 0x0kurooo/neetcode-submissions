class Solution {
    public int maxArea(int[] heights) {
        // water area = (r - l) * (min(h[r], h[l]))
        int maxAmount = 0;
        int l = 0;
        int r = heights.length - 1;
        while (l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            maxAmount = Math.max(maxAmount, area);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxAmount;
    }
}
