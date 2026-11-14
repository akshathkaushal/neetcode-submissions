class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int cur = 1;
        res[0]=1;
        for(int i=1;i<n;i++) {
            res[i] = nums[i-1]*cur;
            cur=res[i];
        }

        cur = 1;
        for(int i=n-2;i>=0;i--) {
            int val = nums[i+1]*cur;
            res[i] = res[i] * (val);
            cur = val;
        }

        return res;
    }
}  
