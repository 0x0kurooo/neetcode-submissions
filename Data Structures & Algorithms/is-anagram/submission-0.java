class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> freqT = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }
        if (freq.size() != freqT.size()) {
            return false;
        }
        for (var entry : freq.entrySet()) {
            char c = entry.getKey();
            Integer count = entry.getValue();
            
            if (!count.equals(freqT.getOrDefault(c, 0))) {
                return false;
            }
        }
        return true;
    }
}
