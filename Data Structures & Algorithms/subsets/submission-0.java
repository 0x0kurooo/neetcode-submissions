class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return backtrack(nums, nums.length - 1);
    }

    public List<List<Integer>> backtrack(int[] nums, int idx) {
        if (idx < 0) {
            var base = new ArrayList<List<Integer>>();
            base.add(new ArrayList<>());
            return base;
        }

        List<List<Integer>> prev = backtrack(nums, idx - 1);
        List<List<Integer>> subset = new ArrayList<>(prev);

        for (var prevSet : prev) {
            List<Integer> newSet = new ArrayList<>(prevSet);
            newSet.add(nums[idx]);
            subset.add(newSet);
        }

        return subset;
    }
}
