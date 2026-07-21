class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<Integer>(), 0, target);
        return answer;
    }

    public void dfs(int[] nums, int idx, List<Integer> currentCombination, int total, int target) {
        if (total == target) {
            answer.add(new ArrayList<>(currentCombination));
            return;
        }
        if (idx >= nums.length || total > target) {
            return;
        }

        // For each idx we have 2 choices, pick it, or skip
        // Firtst, pick the nums and find child combnination
        List<Integer> nextCombination = new ArrayList<>(currentCombination);
        nextCombination.add(nums[idx]);
        dfs(nums, idx + 1, nextCombination, total + nums[idx], target);

        // Second choice, skip this idx and compute next
        int nextIdx = idx + 1;
        while (nextIdx < nums.length && nums[nextIdx] == nums[idx]) {
            nextIdx ++;
        }
        dfs(nums, nextIdx, currentCombination, total, target);
    }
}

