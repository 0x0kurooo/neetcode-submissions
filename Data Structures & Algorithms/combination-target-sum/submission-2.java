class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = backtrack(nums, target, nums.length - 1);
        Set<List<Integer>> dedup = new HashSet<>(answer);
        return new ArrayList<>(dedup);
    }

    public List<List<Integer>> backtrack(int[] nums, int target, int idx) {
        if (idx < 0 || target <= 0) {
            return new ArrayList<>();
        }
        
        // [2, 5, 6, 9] target 9
        // For each num in the list
        // We try to combine the sum with it if the num <= target
        // Pick 2, backtrack(nums, 7)
        // If found the sub-answer then add 2 to it
        // Or skip that and check for combine

        List<List<Integer>> answer = new ArrayList<>();
        if (nums[idx] == target) {
            List<Integer> base = new ArrayList<>();
            base.add(nums[idx]);
            answer.add(base);
        }

        List<List<Integer>> nextComb = backtrack(nums, target - nums[idx], idx - 1);
        for (var comb : nextComb) {
            List<Integer> newComb = new ArrayList<>(comb);
            newComb.add(nums[idx]);
            answer.add(newComb);
        }
        
        List<List<Integer>> includeComb = backtrack(nums, target - nums[idx], idx);
        for (var comb : includeComb) {
            List<Integer> newComb = new ArrayList<>(comb);
            newComb.add(nums[idx]);
            answer.add(newComb);
        }

        List<List<Integer>> excludeComb = backtrack(nums, target, idx - 1);
        for (var comb : excludeComb) {
            answer.add(comb);
        }

        return answer;
    }
}
