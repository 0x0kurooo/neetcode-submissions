class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, new ArrayList<>(), 0, target);
        return answer;
    }

    public void dfs(int[] nums, int idx, List<Integer> currentCombination, int total, int target) {
        // Basecase 
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
        dfs(nums, idx, nextCombination, total + nums[idx], target);

        // Second choice, skip this idx and compute next
        dfs(nums, idx + 1, currentCombination, total, target);
    }
}
