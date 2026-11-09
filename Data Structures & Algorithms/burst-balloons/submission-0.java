class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] values = new int[n+2];
        values[0]=1;
        values[n+1]=1;

        for(int i=1;i<=n;i++) {
            values[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        for(int i=0;i<n+2;i++) Arrays.fill(dp[i],-1);
        return helper(values,1,n,dp);
    }
    private int helper(int[] values, int l, int r, int[][] dp) {
        if(l>r) return 0;

        if(dp[l][r] != -1) return dp[l][r];

        int ans = 0;
        for(int i=l;i<=r;i++) {
            int val = values[l-1]*values[i]*values[r+1] + 
            helper(values,l,i-1,dp) +
            helper(values,i+1,r,dp);
            ans = Math.max(ans,val);
        }
        return dp[l][r] = ans;
    }
}
