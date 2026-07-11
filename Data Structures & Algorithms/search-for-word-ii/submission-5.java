class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null; // store the word in leaf node, prevent backtracking

    public void insert(String str, int idx) {
        // We reached the leaf node, store the string
        if (idx >= str.length()) {
            this.word = str;
            return;
        }

        char c = str.charAt(idx);
        TrieNode node = children.computeIfAbsent(c, k -> new TrieNode());
        node.insert(str, idx + 1);
    }
}

class Solution {
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode trie = new TrieNode();
        for (String word : words) {
            trie.insert(word, 0);
        }

        int rows = board.length;
        int cols = board[0].length;
        for (int row = 0; row < rows; row ++) {
            for (int col = 0; col < cols; col ++) {
                dfs(row, col, board, trie, new HashSet<>());
            }
        }

        return result;
    }

    void dfs(int row, int col, char[][] board, TrieNode trie, Set<String> visited) {
        // Boundary check for board
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }
        
        String key = String.valueOf(row) + ":" + String.valueOf(col);
        if (visited.contains(key)) {
            return;
        }

        char c = board[row][col];
        TrieNode nextNode = trie.children.getOrDefault(c, null);
        if (nextNode == null) {
            return;
        }

        if (nextNode.word != null) {
            result.add(nextNode.word);
            nextNode.word = null;
        }

        int [][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            visited.add(key);
            dfs(row + direction[0], col + direction[1], board, nextNode, visited);
            visited.remove(key);
        }
    }

}
