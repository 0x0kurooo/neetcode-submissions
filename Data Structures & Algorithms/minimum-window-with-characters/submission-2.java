class Solution {
    public String minWindow(String s, String t) {
        int n = t.length();
        int m = s.length();
        if (m < n) return "";
        
        var target = new HashMap<Character, Integer>();
        for (char c: t.toCharArray()) {
            target.merge(c, 1, Integer::sum);
        }

        int minLen = m + 1;
        int minIdx = 0;
        int left = 0, right = 0;
        var window = new HashMap<Character, Integer>();
        while (right < m) {
            window.merge(s.charAt(right), 1, Integer::sum);
            
            int count = 0;
            for (var entry : target.entrySet()) {
                var key = entry.getKey();
                var req = entry.getValue();
                var cur = window.getOrDefault(key, 0);
                if (cur < req) break;
                count++;
            }
            
            // When we have all required char, try to sink from left side
            if (count >= target.size()) {
                while (left < right && window.get(s.charAt(left)) > target.getOrDefault(s.charAt(left), 0)) {
                    window.merge(s.charAt(left), -1, Integer::sum);
                    left++;
                }
                int len = right - left + 1;
                if (len < minLen) {
                    minLen = len;
                    minIdx = left;
                }
            }

            right++;
        }

        if (minLen > m) return "";
        return s.substring(minIdx, minIdx + minLen);
    }
}
