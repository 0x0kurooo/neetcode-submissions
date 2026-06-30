class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int pivot = 0;

        while (l < r) {
            int mid = l + (r - l) / 2;
            
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        pivot = l;

        if (pivot == 0 || target < nums[0]) {
            l = pivot;
            r = nums.length -1;
        } else {
            l = 0;
            r = pivot - 1;
        }

        while (l <= r) {
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
