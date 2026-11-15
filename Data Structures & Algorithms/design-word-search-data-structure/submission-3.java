class WordDictionary {
    public class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchHelper(word,0,temp);
    }
    private boolean searchHelper(String word, int idx, TrieNode temp) {
        if(idx == word.length()) 
            return temp != null && temp.isEnd;
        if(temp == null) return false;

        if(word.charAt(idx) == '.') {
            for(int i=0;i<26;i++) {
                if(searchHelper(word,idx+1,temp.children[i])) 
                    return true;
            }
            return false;
        }
        
        char c = word.charAt(idx);
        return searchHelper(word,idx+1,temp.children[c-'a']);
    }
}
