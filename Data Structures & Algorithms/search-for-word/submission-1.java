class Solution {
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(helper(board,word,0,i,j)) return true;
            }
        }

        return false;
    }
    private int n;
    private int m;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private boolean checkPosition(int x, int y) {
        return x>=0 && x<n && y>=0 && y<m;
    }
    private boolean helper(char[][] board, String word, int idx, int x, int y) {
        if(idx == word.length()) return true;
        if(!checkPosition(x,y) || 
        board[x][y] != word.charAt(idx) || 
        board[x][y] == '#') 
            return false;
        
        boolean ans = false;
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int xx = x+dirs[i][0];
            int yy = y+dirs[i][1];

            ans = ans || helper(board,word,idx+1,xx,yy);
        }
        board[x][y] = word.charAt(idx);
        return ans;
    }
}
