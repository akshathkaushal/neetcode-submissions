class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[21][2001];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);

        return helper(nums,target,0,dp);
    }
    private int helper(int[] nums, int target, int idx, int[][] dp) {
        if(target == 0 && idx == nums.length) return 1;
        if(idx == nums.length && target != 0) return 0;

        if(dp[idx][1000+target] != -1) return dp[idx][1000+target];

        return dp[idx][1000+target] = helper(nums,target+nums[idx],idx+1,dp)+helper(nums,target-nums[idx],idx+1,dp);
    }
}
