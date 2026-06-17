class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            var targetIdx = dict.getOrDefault(target - nums[i], -1);
            if ( targetIdx >= 0) {
                return new int[] {targetIdx, i};
            }

            dict.put(nums[i], i);
        }

        return new int[2];
    }
}
