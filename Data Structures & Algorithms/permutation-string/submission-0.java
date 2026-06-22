class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freqCounter = new int[26];
        Arrays.fill(freqCounter, 0);
        for (char c : s1.toCharArray()) {
            freqCounter[c - 'a']++;
        }

        int[] window = new int[26];
        Arrays.fill(window, 0);
        for (int i = 0; i < s1.length() - 1; i++) {
            window[s2.charAt(i) - 'a']++;
        }

        int left = 0, right = s1.length() - 1;
        while (right < s2.length()) {
            window[s2.charAt(right) - 'a']++;
            
            boolean isPermutation = true;
            for (int i = 0; i < window.length; i++) {
                if (window[i] != freqCounter[i]) {
                    isPermutation = false;
                    break;
                }
            }
            if (isPermutation) return true;

            window[s2.charAt(left) - 'a']--;
            right++;
            left++;
        }

        return false;
    }
}
