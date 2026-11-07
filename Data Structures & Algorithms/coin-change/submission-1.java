class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins,0,amount);
        return (ans == Integer.MAX_VALUE-1) ? -1 : ans;
    }
    private int helper(int[] coins, int idx, int amount) {
        if(amount == 0) return 0;
        if(idx == coins.length || amount < 0) return Integer.MAX_VALUE-1;

        return Math.min(1+helper(coins,idx,amount-coins[idx]),
        helper(coins,idx+1,amount));
    }
}
