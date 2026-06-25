class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();
        Set<String> operators = Set.of("+", "-", "*", "/");

        for (String c : tokens) {
            if (!operators.contains(c)) {
                deque.push(Integer.parseInt(c));
            } else {
                var b = deque.pop();
                var a = deque.pop();
                int res = 0;

                if (c.equals("+")) {
                    res = a + b;
                } else if (c.equals("-")) {
                    res = a - b;
                } else if (c.equals("*")) {
                    res = a * b;
                } else if (c.equals("/")) {
                    res = a / b;
                }
                deque.push(res);
            }
        }

        return deque.pop();
    }
}
