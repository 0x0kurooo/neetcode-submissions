class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Get rows
        for (int i = 0; i < board.length; i++) {
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                nums.add(board[i][j] - '0');
            }
            if (!this.isValid(nums)) {
                return false;
            }
        }

        // Get columns
        for (int j = 0; j < board[0].length; j++) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {
                    continue;
                }
                nums.add(board[i][j] - '0');
            }
            if (!this.isValid(nums)) {
                return false;
            }
        }

        // Get 3x3 grid box
        for (int rowBox = 0; rowBox < 9; rowBox += 3) {
            for (int colBox = 0; colBox < 9; colBox += 3) {
                List<Integer> nums = new ArrayList<>();
                // Get actual box numbers
                for (int i = rowBox; i < rowBox + 3; i++) {
                    for (int j = colBox; j < colBox + 3; j++) {
                        if (board[i][j] == '.') {
                            continue;
                        }
                        nums.add(board[i][j] - '0');
                    }
                }
                if (!this.isValid(nums)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(List<Integer> nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (var n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if (freq.get(n) > 1) {
                return false;
            }
        }

        return true;
    }
}
