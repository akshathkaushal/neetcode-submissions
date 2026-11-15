public class TrieNode {
    private TrieNode[] children;
    private boolean isEnd;
    
    public TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }

    public void set(char c) {
        children[c-'a'] = new TrieNode();
    }

    public TrieNode get(char c) {
        return children[c-'a'];
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

        for(String word : words) {
            TrieNode temp = root;
            for(char c : word.toCharArray()) {
                if(temp.get(c) == null) {
                    temp.set(c);
                }
                temp=temp.get(c);
            }
            temp.markEnd();
        }

        List<String> result = new ArrayList<>();
        /*
            The idea is to iterate the grid and check
            which words are present in the trie
        */
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                StringBuilder str = new StringBuilder();
                dfs(board,i,j,root,result,str);
            }
        }
        return result;
    }
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int n;
    private int m;
    private void dfs(char[][] board, int x, int y, TrieNode node, List<String> result, StringBuilder str) {
        if(x<0 || x>=n || y<0 || y>=m || board[x][y] == '#' || node.get(board[x][y]) == null)
            return;

        TrieNode cur = node.get(board[x][y]);
        str.append(board[x][y]);
        if(cur.isEnd()) {
            result.add(str.toString());
            cur.removeEnd();
        }
        char c = board[x][y];
        board[x][y]='#';
        for(int i=0;i<4;i++) {
            int x1 = x+dirs[i][0];
            int y1 = y+dirs[i][1];

            dfs(board,x1,y1,cur,result,str);
        }

        str.deleteCharAt(str.length()-1);
        board[x][y]=c;
    }
}
