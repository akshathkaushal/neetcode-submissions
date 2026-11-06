class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        return Math.min(helper(cost,0,n,dp),helper(cost,1,n,dp));
    }
    private int helper(int[] cost, int cur, int n, int[] dp) {
        if(cur == n) return 0;
        else if(cur>n) return 1000000;

        if(dp[cur] != 0) return dp[cur];

        return dp[cur] = cost[cur]+Math.min(helper(cost,cur+1,n,dp),helper(cost,cur+2,n,dp));
    }
}
