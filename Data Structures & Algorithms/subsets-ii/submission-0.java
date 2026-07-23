class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        if (start >= nums.length) {
            return;
        }
        
        int next = start + 1;
        while (next < nums.length && nums[start] == nums[next]) {
            next ++;
        }

        path.add(nums[start]);
        result.add(new ArrayList<>(path));
        backtrack(nums, start + 1, path, result);
        path.removeLast();

        backtrack(nums, next, path, result);
    }

    /*
    [1, 2, 1] -> [1, 1, 2]
    For array with 3 elements
    We can take 0 -> []
    Or take 1 -> [1], [1], [2]
    Or take 2 -> [1, 1], [1, 1], [1, 2]
    Or take all -> [1, 1, 2]

    Then we can create function bactrack(nums, result)
    If nums = [] -> []
    If nums = [1] -> [1] + backtrack(nums.pop()) -> [], [1]
    If nums [1, 2] -> [1] + backtrack([2]) + [2] + backtrack([1]) -> [], [1], [2], [1, 2], [2, 1]
    If nums [1, 1, 2] -> [1] + backtrack([1, 2]), [2] + backtrack([1, 1])
    */
}
