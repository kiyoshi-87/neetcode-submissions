class WordDictionary {
    TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(root, 0, word);
    }

    private boolean searchInNode(TrieNode node, int index, String word) {
        if (index == word.length()) {
            return node.end;
        }

        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.hm.values()) {
                if (searchInNode(child, index + 1, word)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.hm.containsKey(ch)) {
                return false;
            }
            return searchInNode(node.hm.get(ch), index + 1, word);
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> hm = new HashMap<>();
    boolean end = false;

    public TrieNode() {}
}