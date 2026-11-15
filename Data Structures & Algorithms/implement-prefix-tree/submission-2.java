class PrefixTree {
    public static class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            if(temp.children[c-'a'] == null) {
                temp.children[c-'a'] = new TrieNode();
            }
            temp = temp.children[c-'a'];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            if(temp.children[c-'a'] == null) return false;
            temp = temp.children[c-'a'];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(char c : prefix.toCharArray()) {
            if(temp.children[c-'a'] == null) return false;
            temp = temp.children[c-'a'];
        }
        return true;
    }
}
