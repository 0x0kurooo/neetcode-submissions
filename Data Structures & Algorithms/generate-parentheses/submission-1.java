class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, n, "", result);
        return result;
    }

    public void backtrack(int n, int open, int close, String parenthese, List<String> result) {
        if (parenthese.length() == n * 2) {
            result.add(parenthese);
            return;
        }

        if (open == 0) {
            backtrack(n, open, close - 1, parenthese + ")", result);
            return;
        }
        if (close == open) {
            backtrack(n, open - 1, close, parenthese + "(", result);
            return;
        }
        backtrack(n, open - 1, close, parenthese + "(", result);
        backtrack(n, open, close - 1, parenthese + ")", result);
    }
}
