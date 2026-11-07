class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int i=0;i<=n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(coins,0,amount,dp);
    }
    private int helper(int[] coins, int idx, int amount, int[][] dp) {
        if(amount == 0) return 1;
        else if(idx == coins.length || amount < 0) return 0;

        if(dp[idx][amount] != -1) return dp[idx][amount];

        return dp[idx][amount] = helper(coins,idx,amount-coins[idx],dp) + helper(coins,idx+1,amount,dp);
    }
}
