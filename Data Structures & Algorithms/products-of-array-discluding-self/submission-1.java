class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int cur = 1;
        for(int i=1;i<n;i++) {
            res[i] = nums[i-1]*cur;
            cur=res[i];
        }

        cur = 1;
        for(int i=n-2;i>=1;i--) {
            int val = nums[i+1]*cur;
            res[i] = res[i] * (val);
            cur = val;
        }
        res[0] = nums[1]*cur;

        return res;
    }
}  
