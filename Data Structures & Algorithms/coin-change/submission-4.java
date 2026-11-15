class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        int ans = helper(coins,0,amount,dp);
        return ans == Integer.MAX_VALUE-1 ? -1 : ans;
    }
    private int helper(int[] coins, int idx, int amount, int[][] dp) {
        if(amount==0) return 0;
        if(idx==coins.length || amount<0) return Integer.MAX_VALUE-1;

        if(dp[idx][amount] != 0) return dp[idx][amount];

        return dp[idx][amount] = Math.min(
            1+helper(coins,idx,amount-coins[idx],dp),
            helper(coins,idx+1,amount,dp)
        );
    }
}
