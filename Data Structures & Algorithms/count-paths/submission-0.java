class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);

        return helper(m-1,n-1,dp);
    }
    private int helper(int x, int y, int[][] dp) {
        if(x==0 && y==0) return 1;
        else if(x<0 || y<0) return 0;
        if(dp[x][y] != -1) return dp[x][y];

        return dp[x][y] = helper(x-1,y,dp)+helper(x,y-1,dp);
    }
}
