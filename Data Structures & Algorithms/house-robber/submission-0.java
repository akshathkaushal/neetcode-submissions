class Solution {
    public int rob(int[] nums) {
        int idx = 0;
        int[] dp = new int[nums.length+1];
        return helper(nums,idx,dp);
    }
    private int helper(int[] nums, int idx, int[] dp) {
        if(idx >= nums.length) return 0;

        if(dp[idx] != 0) return dp[idx];
        return dp[idx] = Math.max(nums[idx]+helper(nums,idx+2,dp), helper(nums,idx+1,dp));
    }
}
