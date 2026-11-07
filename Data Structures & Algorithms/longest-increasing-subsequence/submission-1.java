class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return helper(nums,0,-1,dp);
    }
    private int helper(int[] nums, int idx, int pIdx, int[][] dp) {
        if(idx==nums.length) return 0;

        if(dp[idx][pIdx+1] != -1) return dp[idx][pIdx+1];

        int take=0, notTake=0;
        if(pIdx == -1 || nums[idx] > nums[pIdx]) {
            take = 1+helper(nums,idx+1,idx,dp);
        }
        notTake = helper(nums,idx+1,pIdx,dp);

        return dp[idx][pIdx+1] = Math.max(take,notTake);
    }
}
