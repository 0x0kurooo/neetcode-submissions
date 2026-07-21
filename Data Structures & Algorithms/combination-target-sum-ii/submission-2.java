class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    public void dfs(int[] nums, int start, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > remaining) {
                break;
            }
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            path.add(nums[i]);
            dfs(nums, i + 1, remaining - nums[i], path, result);
            path.removeLast();
        }
    }
}
