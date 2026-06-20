class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i ++) {
            // In sorted nums, skip if this num same as prev for prevent duplication
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // Do the two sum
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int current = nums[i] + nums[l] + nums[r];
                if (current == 0) {
                    res.add(List.of(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (current < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return res;
    }
}
