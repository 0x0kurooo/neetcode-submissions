class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int area = 0;

        while (left < right) {
            // Update running maxes to include the bar at the current pointer
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                // leftMax is the smaller of the two known maxes, so it's also
                // the true min(leftMax[left], rightMax[left]) — because the
                // *true* rightMax[left] (unscanned) is guaranteed >= rightMax,
                // which is already > leftMax. The left side is "settled".
                area += leftMax - height[left];
                left++;
            } else {
                // Symmetric case: rightMax <= leftMax, so rightMax is the
                // settled min for this position. The true leftMax[right]
                // (unscanned) is guaranteed >= leftMax >= rightMax.
                area += rightMax - height[right];
                right--;
            }
        }

        return area;
    }
}