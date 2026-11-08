class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 1;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                ans = Math.max(ans, dfs(matrix,i,j,n,m,dp));
            }
        }
        return ans;
    }
    private int dfs(int[][] matrix, int x, int y, int n, int m, int[][] dp) {
        if(dp[x][y] > 0) return dp[x][y];

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        int ans = 0;
        for(int k=0;k<4;k++) {
            int x1 = x+dirs[k][0];
            int y1 = y+dirs[k][1];
            if(
                (x1<n && x1>=0 && y1<m && y1>=0) && 
                (matrix[x1][y1] > matrix[x][y])
            ) {
                ans = Math.max(ans,dfs(matrix,x1,y1,n,m,dp));
            }
        }
        return dp[x][y] = 1+ans;
    }
}
