class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        
        int[] dp1 = new int[len+1];
        Arrays.fill(dp1,-1);
        int[] dp2 = new int[len+1];
        Arrays.fill(dp2,-1);

        return Math.max(helper(nums, 0, len-1, dp1),helper(nums, 1, len, dp2));
    }
    private int helper(int[] nums, int cur, int max, int[] dp) {
        if(cur >= max) return 0;

        if(dp[cur] != -1) return dp[cur];

        return dp[cur] = Math.max(nums[cur]+helper(nums,cur+2,max,dp), 
        helper(nums,cur+1,max,dp));
    }
}
