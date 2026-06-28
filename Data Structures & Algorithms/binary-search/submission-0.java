class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int middle = (r + l) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }

        return -1;
    }
}
