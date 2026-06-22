class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        
        int left = 0;
        int longest = 0;
        for (int i = 0; i < s.length(); i ++) {
            var c = s.charAt(i);
            if (lastSeen.containsKey(c)) {
                left = Math.max(left, lastSeen.get(c) + 1);
            }
            lastSeen.put(c, i);
            longest = Math.max(longest, i - left + 1);
        }

        return longest;
    }
}
