class TrieNode {
    TrieNode[] children;
    String word;
    public TrieNode() {
        children = new TrieNode[26];
        word=null;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        // build trie
        for(String word : words) {
            TrieNode temp = root;
            for(char c : word.toCharArray()) {
                if(temp.children[c-'a'] == null) {
                    temp.children[c-'a'] = new TrieNode();
                }
                temp = temp.children[c-'a'];
            }
            temp.word=word;
        }

        List<String> result = new ArrayList<>();
        // Run DFS on the grid to check for words
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dfs(board,i,j,root,result);
            }
        }
        return result;
    }
    private int n;
    private int m;
    private void dfs(char[][] board, int x, int y, TrieNode root, List<String> result) {
        if(root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        if(x<0 || x>=n || y<0 || y>=m || 
        board[x][y] == '#' || 
        root.children[board[x][y]-'a'] == null) 
            return; 

        char c = board[x][y];
        TrieNode child = root.children[c-'a'];
        board[x][y] = '#';
        dfs(board,x+1,y,child,result);
        dfs(board,x-1,y,child,result);
        dfs(board,x,y+1,child,result);
        dfs(board,x,y-1,child,result);
        board[x][y] = c;
    }
}
