class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(helper(nums,0,n-1,dp1),helper(nums,1,n,dp2));
    }
    private int helper(int[] nums, int idx, int maxIdx, int[] dp) {
        if(idx >= maxIdx) return 0;

        if(dp[idx] != -1) return dp[idx];

        return dp[idx] = Math.max(
            nums[idx]+helper(nums,idx+2,maxIdx,dp),
            helper(nums,idx+1,maxIdx,dp)
        );
    }
}
