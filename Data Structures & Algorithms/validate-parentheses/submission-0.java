class Solution {
    public boolean isValid(String s) {
        var open = Set.of('(', '{', '[');
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');

        Deque<Character> deque = new ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty() || open.contains(c)) {
                deque.addFirst(c);
            } else {
                char head = deque.peekFirst();
                char pair = pairs.get(c);
                if (head == pair) {
                    deque.pollFirst();
                } else {
                    deque.addFirst(c);
                }
            }
        }

        return deque.isEmpty();
    }
}
