class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }
    private int helper(int[] nums, int idx, int[] dp) {
        if(idx == nums.length-1) return 0;
        else if(idx >= nums.length) return Integer.MAX_VALUE-1;

        if(dp[idx] != -1) return dp[idx];

        int ans = Integer.MAX_VALUE-1;
        for(int i=1;i<=nums[idx];i++) {
            ans = Math.min(ans,1+helper(nums,idx+i,dp));
        }
        return dp[idx] = ans;
    }
}
