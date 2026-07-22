class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, result);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        // When we reach full path of permutation, add it to result
        if (path.size() == nums.length) {
            List<Integer> permutation = new ArrayList<>(path);
            result.add(permutation);
            return;
        }

        for (int i = 0; i < nums.length; i++ ) {
            if (used[i]) continue; // skip idx that used in the path
            
            // Create new path and find its permutation
            path.add(nums[i]);
            used[i] = true; // track this as choosed
            
            backtrack(nums, path, used, result);

            used[i] = false; // untrack after use
            path.removeLast();
        }
    }
}
