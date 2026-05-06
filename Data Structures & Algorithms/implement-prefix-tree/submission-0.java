class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.hm.containsKey(ch)) {
                node.hm.put(ch, new TrieNode());
            }
            node = node.hm.get(ch);
        }

        node.end = true;
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (char ch: word.toCharArray()) {
            if (!node.hm.containsKey(ch)) {
                return false;
            }

            node = node.hm.get(ch);
        }

        return node.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (char ch: prefix.toCharArray()) {
            if (!node.hm.containsKey(ch)) {
                return false;
            }

            node = node.hm.get(ch);
        }

        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> hm = new HashMap<>();
    boolean end = false;

    public TrieNode() {}
}
