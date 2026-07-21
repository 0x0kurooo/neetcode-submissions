class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, target, new ArrayList<>(), result);
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

            path.add(nums[i]);
            dfs(nums, i, remaining - nums[i], path, result);
            path.remove(path.size() - 1);
        }
    }
}
