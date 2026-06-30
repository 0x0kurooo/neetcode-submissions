class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int smallest = 0;

        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        smallest = l;

        l = 0;
        r = smallest - 1;

        if (smallest == 0 || target < nums[0]) {
            l = smallest;
            r = nums.length -1;
        }

        while (l >= 0 && r < nums.length && l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;

            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        return -1;
    }
}
