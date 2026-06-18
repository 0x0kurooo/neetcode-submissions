class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (numberMap.containsKey(target - n)) {
                int idx = numberMap.get(target - n);
                return new int[] {idx + 1, i + 1};
            }
            
            numberMap.put(n, i);
        }

        return new int[2];
    }
}
