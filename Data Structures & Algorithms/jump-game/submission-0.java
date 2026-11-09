class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    private boolean helper(int[] nums, int idx, int[] dp) {
        if(idx == nums.length-1) return true;

        if(dp[idx] != -1) return dp[idx]==1;

        for(int i=1;i<=nums[idx];i++) {
            if(helper(nums,idx+i,dp)) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}
