class Solution {

    public String encode(List<String> strs) {
        // ['a', 'abc'] -> 1#a3#abc
        String encoded = "";
        for (var s: strs) {
            var len = s.length();
            encoded += len + "#" + s;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        int idx = 0;
        while (idx < str.length()) {
            int len = 0;
            while (str.charAt(idx) != '#') {
                len = len * 10 + str.charAt(idx) - '0';
                idx ++;
            }
            idx ++; // skip #
            strs.add(str.substring(idx, idx + len));
            idx += len;
        }

        return strs;
    }
}
