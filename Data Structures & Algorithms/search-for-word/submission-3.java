class Solution {
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(helper(board,i,j,word,0)) 
                    return true;
            }
        }

        return false;
    }
    private int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    private int n;
    private int m;
    private boolean helper(char[][] board, int x, int y, String word, int idx) {
        if(idx == word.length()) return true;
        if(x<0 || x>=n || y<0 || y>=m || board[x][y] != word.charAt(idx)) 
            return false;

        boolean ans = false;
        board[x][y] = '#';
        for(int i=0;i<4;i++) {
            int x1 = x+dirs[i][0];
            int y1 = y+dirs[i][1];

            ans = ans || helper(board,x1,y1,word,idx+1);
        }
        board[x][y] = word.charAt(idx);
        return ans;
    }
}
