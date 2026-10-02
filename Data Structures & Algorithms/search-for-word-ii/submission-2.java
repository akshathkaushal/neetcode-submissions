class TrieNode {
    TrieNode[] nodes;
    boolean isEnd;

    public TrieNode() {
        nodes = new TrieNode[26];
        isEnd = false;
    }

    public void set(char c) {
        nodes[c-'a'] = new TrieNode();
    }
    public TrieNode get(char c) {
        return nodes[c-'a'];
    }

    public boolean isEnd() {
        return isEnd;
    }
    public void markEnd() {
        isEnd=true;
    }
    public void removeEnd() {
        isEnd=false;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        // Create trie of all the words
        for(String word : words) {
            TrieNode temp = root;
            for(char c : word.toCharArray()) {
                if(temp.get(c) == null) {
                    temp.set(c);
                }
                temp = temp.get(c);
            }
            temp.markEnd();
        }
        
        List<String> res = new ArrayList<>();
        // Iterate the grid to check for words
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dfs(board,i,j,n,m,root,res,"");
            }
        }
        return res;
    }
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(char[][] board, 
                    int x, int y, 
                    int n, int m, 
                    TrieNode cur, 
                    List<String> res,
                    String temp) {
        // base condition: if x,y are out of bounds, or trie node is null
        if(x<0 || x>=n || y<0 || y>=m || board[x][y] == '#' || cur.get(board[x][y]) == null) 
            return;

        TrieNode curNode = cur.get(board[x][y]);
        if(curNode.isEnd()) {
            res.add(temp+board[x][y]);
            curNode.removeEnd();
        }

        char curChar = board[x][y];
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int x_ = x+dirs[i][0];
            int y_ = y+dirs[i][1];

            dfs(board,x_,y_,n,m,curNode,res,temp+curChar);
        }
        board[x][y] = curChar;
    }
}
