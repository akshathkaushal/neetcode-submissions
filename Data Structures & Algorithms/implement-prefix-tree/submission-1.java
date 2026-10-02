class PrefixTree {
    class TrieNode {
        TrieNode[] nodes;
        boolean end;

        public TrieNode() {
            nodes = new TrieNode[26];
            end = false;
        }

        public boolean isEnd() {
            return end;
        }

        public void markEnd() {
            end = true;
        }

        public TrieNode getNode(char c) {
            return nodes[c-'a'];
        }

        public void setNode(char c) {
            nodes[c-'a'] = new TrieNode();
        }
    }

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode head = root;

        for(char c : word.toCharArray()) {
            if(head.getNode(c) == null) {
                head.setNode(c);
            }
            head = head.getNode(c);
        }
        head.markEnd();
    }

    public boolean search(String word) {
        TrieNode head = root;
        
        for(char c : word.toCharArray()) {
            if(head.getNode(c) == null) return false;
            head = head.getNode(c);
        }

        return head.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode head = root;

        for(char c : prefix.toCharArray()) {
            if(head.getNode(c) == null) return false;
            head = head.getNode(c);
        }
        return true;
    }
}
