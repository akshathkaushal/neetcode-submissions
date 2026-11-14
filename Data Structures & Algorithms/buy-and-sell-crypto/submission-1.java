class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=1, ans=0;
        while(r<prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r]-prices[l];
                ans = Math.max(ans,profit);
            } else {
                l=r;
            }
            r++;
        }
        return ans;
    }
}
