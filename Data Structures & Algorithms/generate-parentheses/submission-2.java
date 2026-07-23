class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(n, n, n, new StringBuilder(), result);
        return result;
    }

    public void backtrack(int n, int open, int close, StringBuilder parenthese, List<String> result) {
        if (parenthese.length() == n * 2) {
            result.add(parenthese.toString());
            return;
        }

        if (open == 0) {
            parenthese.append(')');
            backtrack(n, open, close - 1, parenthese, result);
            parenthese.deleteCharAt(parenthese.length() - 1);
            return;
        }
        if (close == open) {
            parenthese.append('(');
            backtrack(n, open - 1, close, parenthese, result);
            parenthese.deleteCharAt(parenthese.length() - 1);
            return;
        }

        parenthese.append('(');
        backtrack(n, open - 1, close, parenthese, result);
        parenthese.deleteCharAt(parenthese.length() - 1);
        
        parenthese.append(')');
        backtrack(n, open, close - 1, parenthese, result);
        parenthese.deleteCharAt(parenthese.length() - 1);
    }
}
