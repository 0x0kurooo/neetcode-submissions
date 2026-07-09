
class PrefixTree {
    class Node {
        Character val;
        Map<Character, Node> buckets = new HashMap<>();
        boolean isCompleted = false;

        public Node(Character c) {
            val = c;
        }

        public void insert(String word) {
            if (word.length() == 0) {
                isCompleted = true;
                return;
            }

            char c = word.charAt(0);
            Node node = buckets.computeIfAbsent(c, k -> new Node(c));
            node.insert(word.substring(1));
        }

        public Node startsWith(String prefix) {
            if (prefix.length() == 0) {
                return this;
            }

            char c = prefix.charAt(0);
            if (!buckets.containsKey(c)) {
                return null;
            }

            return buckets.get(c).startsWith(prefix.substring(1));
        }

        public Node search(String word) {
            if (word.length() == 0) {
                if (isCompleted) return this;
                return null;
            }


            char c = word.charAt(0);
            if (!buckets.containsKey(c)) {
                return null;
            }
            return buckets.get(c).search(word.substring(1));
        }
    }

    Node root;

    public PrefixTree() {
        root = new Node('-');
    }

    public void insert(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        Node node = root.search(word);
        return node != null;
    }

    public boolean startsWith(String prefix) {
        Node node = root.startsWith(prefix);
        return node != null;
    }
}
