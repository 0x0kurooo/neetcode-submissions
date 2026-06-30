class Solution {
    public int findMin(int[] nums) {
        return this.helper(nums, 0, nums.length-1);
    }

    public int helper(int[] nums, int l, int r) {
        if (l <= r) {
            if (nums[l] < nums[r]) return nums[l];

            int mid = (r + l) / 2;
            if (mid - 1 >=0 && 
            nums[mid-1] > nums[mid]) {
                return nums[mid];
            }

            int leftMin = this.helper(nums, l, mid - 1);
            int rightMin = this.helper(nums, mid + 1, r);

            return Math.min(leftMin, rightMin);
        }

        return nums[0];
    }
}
