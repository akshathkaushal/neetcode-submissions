class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[3][n+1];
        for(int i=0;i<3;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(prices, 0, 1, dp); // true for buy, false for sell
    }
    private int helper(int[] prices, int idx, int buy, int[][] dp) {
        if(idx >= prices.length) return 0;

        if(dp[buy][idx] != -1) return dp[buy][idx];

        if(buy == 1) {
            return dp[buy][idx] = Math.max(
                -prices[idx]+helper(prices,idx+1,0,dp), 
                helper(prices,idx+1,1,dp)
            );
        } 
        return dp[buy][idx] = Math.max(
            prices[idx]+helper(prices,idx+2,1,dp), 
            helper(prices,idx+1,0,dp)
        );
    }
}
