class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],-1);
        return helper(nums, 0, -1, dp);
    }
    private int helper(int[] nums, int cur, int prev, int[][] dp) {
        if(cur == nums.length) return 0;

        if(dp[cur][prev+1] != -1) return dp[cur][prev+1];

        int take=0, notTake=0;
        if(prev == -1 || nums[cur] > nums[prev]) {
            take = 1+helper(nums,cur+1,cur,dp);
        }
        notTake = helper(nums,cur+1,prev,dp);
        return dp[cur][prev+1] = Math.max(take,notTake);
    }
}
