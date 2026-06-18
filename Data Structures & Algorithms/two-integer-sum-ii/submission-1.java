class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int current = numbers[l] + numbers[r];
            if (current == target) {
                break;
            }

            if (current < target) {
                // Need to be increase the l for incr value of current
                l++;
            } else {
                r--;
            }
        }

        return new int[] {l + 1, r + 1};

        // Map<Integer, Integer> numberMap = new HashMap<>();
        // for (int i = 0; i < numbers.length; i++) {
        //     int n = numbers[i];
        //     if (numberMap.containsKey(target - n)) {
        //         int idx = numberMap.get(target - n);
        //         return new int[] {idx + 1, i + 1};
        //     }
            
        //     numberMap.put(n, i);
        // }

        // return new int[2];
    }
}
