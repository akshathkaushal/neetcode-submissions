class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++) Arrays.fill(dp[i],-1);
        return helper(m-1,n-1,dp);
    }
    private int helper(int m, int n, int[][] dp) {
        if(m==0 && n==0) return 1;
        else if(m<0 || n<0) return 0;

        if(dp[m][n] != -1) return dp[m][n];

        return dp[m][n] = helper(m-1,n,dp)+helper(m,n-1,dp);
    }
}
