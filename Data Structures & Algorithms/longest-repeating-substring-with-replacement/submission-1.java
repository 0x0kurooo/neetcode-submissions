class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqCounter = new HashMap<>();
        
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqCounter.merge(c, 1, Integer::sum);
            int freq = freqCounter.get(c);
            maxFreq = Math.max(maxFreq, freq);
            int tobeReplace = (i - left + 1) - maxFreq; // total chars - max freq chars
            
            if (tobeReplace <= k) {
                maxLen = Math.max(maxLen, i - left + 1);
            } else {
                while ((i - left + 1) - maxFreq > k) {
                    freqCounter.merge(s.charAt(left), -1, Integer::sum);
                    left++;
                }
            }
        }

        return maxLen;
    }
}
