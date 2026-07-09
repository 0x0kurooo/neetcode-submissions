
class Node {
    Character val;
    Map<Character, Node> buckets = new HashMap<>();
    boolean isCompleted = false;

    public Node(Character c) {
        val = c;
    }

    public void insert(String word, int idx) {
        if (idx >= word.length()) {
            isCompleted = true;
            return;
        }

        char c = word.charAt(idx);
        Node node = buckets.computeIfAbsent(c, k -> new Node(c));
        node.insert(word, idx +1);
    }

    public Node startsWith(String prefix, int idx) {
        if (idx >= prefix.length()) {
            return this;
        }

        char c = prefix.charAt(idx);
        if (!buckets.containsKey(c)) {
            return null;
        }

        return buckets.get(c).startsWith(prefix, idx + 1);
    }

    public Node search(String word, int idx) {
        if (idx >= word.length()) {
            if (isCompleted)
                return this;
            
            return null;
        }

        char c = word.charAt(idx);
        if (!buckets.containsKey(c)) {
            return null;
        }
        return buckets.get(c).search(word, idx + 1);
    }
}

class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node('-');
    }

    public void insert(String word) {
        root.insert(word, 0);
    }

    public boolean search(String word) {
        Node node = root.search(word, 0);
        return node != null;
    }

    public boolean startsWith(String prefix) {
        Node node = root.startsWith(prefix, 0);
        return node != null;
    }
}
