class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
        return backtrack(numbers);
    }

    /*
    [1, 2, 3] 

    Permutation [1, 2, 3]:
    
    Pick 1: 
    [1, ] + permutations of [2, 3]
    Permutation [2, 3]:
     - Pick 2:
        [2, ] + permutation of [3]
        Permutation [3]:
        - We have 1 element -> return basecase [3]
     - Pick 3:
        [3, ] + permutation of [2]
        Same here 1 mutation of [2]
    Permutation [2, 3] -> [2, 3], [3, 2]
    [1] + [2, 3], [1] + [3, 2] -> Push to result

    Move to next index
    Pick 2:
    [2] + Permutation of [1, 3]
    -> [2] + [1, 3], [2] + [3, 1]

    Move to next:
    Pick 3:
    [3] + Permutation of [1, 2]
    -> [3] + [1, 2], [3] + [2, 1]
    */

    public List<List<Integer>> backtrack(List<Integer> nums) {
        if (nums.size() == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            List<Integer> permutation = new ArrayList<>(nums);
            result.add(permutation);
            return result;
        }

        for (int i = 0; i < nums.size(); i++) {
            int curr = nums.get(i);
            nums.remove(i);
            List<List<Integer>> nextPermutations = backtrack(nums);
            for (var permutation: nextPermutations) {
                List<Integer> newPermutation = new ArrayList<>(permutation);
                newPermutation.addFirst(curr);
                result.add(newPermutation);
            }
            nums.add(i, curr);
        }

        return result;
    }
}
