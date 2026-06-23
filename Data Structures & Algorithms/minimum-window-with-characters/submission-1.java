class Solution {
    public String minWindow(String s, String t) {
        // Start with 2 pointer left & right
        // And use the window map to track the character freq
        // We can start the window size first by the size of t
        // Then moving the window from start to end until the right pointer hit the end of string S
        // If the the sub string cannot be found, then we repeat the process but with +1 more window size

        // Time compexity: O(n * m)
        
        int n = t.length();
        int m = s.length();

        if (m < n) return "";

        Map<Character, Integer> target = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            target.merge(c, 1, Integer::sum);
        }

        for (int windowRange = n; windowRange <= m; windowRange++) {
            // Create the window
            Map<Character, Integer> window = new HashMap<Character, Integer>();
            for (int i = 0; i < windowRange-1; i++) {
                window.merge(s.charAt(i), 1, Integer::sum);
            }

            int left = 0, right = windowRange-1;
            while (right < m) {
                window.merge(s.charAt(right), 1, Integer::sum);
            
                // Compare to find substr
                int charMatch = 0;
                for (var entry : target.entrySet()) {
                    var key = entry.getKey();
                    var count = entry.getValue();
                    if (!window.containsKey(key) || count > window.get(key)) {
                        break;
                    }
                    charMatch++;
                }
                if (charMatch == target.size()) return s.substring(left, right + 1);

                // Update the window and move foward
                window.merge(s.charAt(left), -1, Integer::sum);
                right++;
                left++;
            }
        }

        return "";        
    }
}
