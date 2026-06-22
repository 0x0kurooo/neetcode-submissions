class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        Map<Character, Integer> freqCounter = new HashMap<>();
        int l = 0, r = 1;
        freqCounter.put(s.charAt(0), 1);
        int longest = 1;

        while (r < s.length()) {
            char c = s.charAt(r);
            freqCounter.put(c, freqCounter.getOrDefault(c, 0) + 1);
            // freqCounter.forEach((key, value) -> System.out.println(key + " : " + value));
            // System.out.println("---");
            while (freqCounter.get(c) > 1) {
                var lastC = s.charAt(l);
                freqCounter.put(lastC, freqCounter.get(lastC) - 1);
                l++;
            }
            
            longest = Math.max(r - l + 1, longest);
            r++;
        }

        return longest;
    }
}
