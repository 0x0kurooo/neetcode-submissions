class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m) return false;

        var target = new int[26];
        var window = new int[26];

        for (int i = 0; i < n; i++) {
            target[s1.charAt(i) - 'a'] ++;
            window[s2.charAt(i) - 'a'] ++;
        }

        if (Arrays.equals(target, window)) return true;

        int left = 0;
        for (int right = n; right < m; right ++) {
            window[s2.charAt(left) - 'a'] --;
            window[s2.charAt(right) - 'a'] ++;

            if (Arrays.equals(target, window)) return true;
            left ++;
        }

        return false;
    }
}
