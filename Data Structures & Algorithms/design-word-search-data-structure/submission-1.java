class TrieNode {
    TrieNode[] nodes;
    boolean end;

    public TrieNode() {
        nodes = new TrieNode[26];
        end = false;
    }

    public TrieNode get(char c) {
        return nodes[c-'a'];
    }

    public void set(char c) {
        nodes[c-'a'] = new TrieNode();
    }

    public boolean isEnd() {
        return end;
    }

    public void markEnd() {
        end=true;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode temp = root;
        for(char c : word.toCharArray()) {
            if(temp.get(c) == null) {
                temp.set(c);
            }
            temp = temp.get(c);
        }
        temp.markEnd();
    }

    public boolean search(String word) {
        TrieNode temp = root;
        return searchHelper(word,0,temp);
    }
    private boolean searchHelper(String word, int pos, TrieNode cur) {
        if(cur == null) return false;
        if(pos == word.length()) return cur.isEnd();

        char curChar = word.charAt(pos);
        TrieNode next = null;
        if(curChar == '.') {
            for(int i=0;i<26;i++) {
                next = cur.get((char)(i+'a'));
                if(searchHelper(word,pos+1,next)) return true;
            }
        } else {
            next = cur.get(curChar);
            if(next == null) return false;
        }

        return searchHelper(word,pos+1,next);
    }
}
