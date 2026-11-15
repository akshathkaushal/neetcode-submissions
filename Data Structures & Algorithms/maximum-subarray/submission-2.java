class Solution {
    public int maxSubArray(int[] nums) {
        int curSum=nums[0], maxSum=nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++) {
            curSum += nums[i];
            if(curSum < nums[i]) {
                curSum = nums[i];
            }

            maxSum = Math.max(maxSum,curSum);
        }

        return maxSum;
    }
}
