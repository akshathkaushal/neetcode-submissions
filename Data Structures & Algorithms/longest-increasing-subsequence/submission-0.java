class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[1001][2002];
        for(int i=0;i<1001;i++) Arrays.fill(dp[i],-1);
        return helper(nums,0,-1001,dp);
    }
    private int helper(int[] nums, int idx, int prev, int[][] dp) {
        if(idx==nums.length) return 0;

        if(dp[idx][prev+1001] != -1) return dp[idx][prev+1001];

        if(nums[idx] > prev) {
            return dp[idx][prev+1001] = Math.max(
                1+helper(nums,idx+1,nums[idx],dp),
                helper(nums,idx+1,prev,dp));
        }
        return dp[idx][prev+1001] = helper(nums,idx+1,prev,dp);
    }
}
