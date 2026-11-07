class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n:nums) sum+=n;
        // cannot divide odd sum
        if((sum & 1) == 1) return false;
        int[][] dp = new int[nums.length+1][sum/2+1];
        for(int i=0;i<=nums.length;i++) Arrays.fill(dp[i],-1);
        return helper(nums,0,sum/2,dp);
    }
    private boolean helper(int[] nums, int idx, int sum, int[][] dp) {
        if(sum == 0) return true;
        else if(sum<0 || idx == nums.length) return false;
        if(dp[idx][sum] != -1) {
            return dp[idx][sum]==0 ? false : true;
        }

        boolean ans = 
        helper(nums,idx+1,sum-nums[idx],dp) || 
        helper(nums,idx+1,sum,dp);
        if(ans) 
            dp[idx][sum] = 1;
        else 
            dp[idx][sum] = 0;
        
        return ans;
    }
}
