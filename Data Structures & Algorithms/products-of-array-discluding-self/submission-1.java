class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = nums[0];
        int[] products = new int[nums.length];
        int[] reverseProducts = new int[nums.length];

        for (int i = 0; i < nums.length; i ++) {
            products[i] = nums[i];
            if (i - 1 >= 0) {
                products[i] = products[i] * products[i-1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i --) {
            reverseProducts[i] = nums[i];
            if (i + 1 < nums.length) {
                reverseProducts[i] = reverseProducts[i] * reverseProducts[i + 1];
            }
        }

        int[] ans = new int[nums.length];
        ans[0] = reverseProducts[1];
        ans[nums.length-1] = products[nums.length-2];

        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = products[i-1] * reverseProducts[i+1];
        }

        return ans;
    }
}  
