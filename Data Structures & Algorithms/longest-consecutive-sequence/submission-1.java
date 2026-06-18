class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int n : nums) {
            numsMap.put(n, 1);
        }

        int longest = 1;
        for (var entry : numsMap.entrySet()) {
            var n = entry.getKey();

            int seq = 1;
            for (int i = 1; i < nums.length; i++) {
                if (!numsMap.containsKey(n + i)) {
                    break;
                }
                seq ++;
                longest = Integer.max(seq, longest);
            }
        }
        return longest;
    }
}
