class Solution {
    public int trap(int[] height) {
        // Store max left of position i
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        // no boundary for left and right side
        int currentLeftMax = 0;
        for (int i = 0; i < height.length; i ++) {
            currentLeftMax = Math.max(currentLeftMax, height[i]);
            leftMax[i] = currentLeftMax;
        }

        int currentRightMax = 0;
        for (int i = height.length - 1; i >= 0; i --) {
            currentRightMax = Math.max(currentRightMax, height[i]);
            rightMax[i] = currentRightMax;
        }

        int area = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int a = Math.min(leftMax[i-1], rightMax[i+1]) - height[i];
            if (a > 0) {
                area += a;
            }
        }
        return area;
    }
}
