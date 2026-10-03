class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++) {
            dfs(board,i,0,n,m);
            dfs(board,i,m-1,n,m);
        }

        for(int j=0;j<m;j++) {
            dfs(board,0,j,n,m);
            dfs(board,n-1,j,n,m);
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(board[i][j] == '#') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X'; 
            }
        }
    }

    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public void dfs(char[][] board, int x, int y, int n, int m) {
        if(x<0 || x>=n || y<0 || y>=m || board[x][y] != 'O') return;

        board[x][y] = '#';

        for(int[] dir : dirs) {
            int a = x+dir[0];
            int b = y+dir[1];

            dfs(board,a,b,n,m);
        }
    }
}
