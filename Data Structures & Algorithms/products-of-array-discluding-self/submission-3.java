class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int prefix = 1;
        res[0]=prefix;
        for(int i=1;i<n;i++) {
            res[i] = prefix*nums[i-1];
            prefix=res[i];
        }

        int suffix = 1;
        for(int i=n-2;i>=0;i--) {
            suffix *= nums[i+1];
            res[i] *= suffix;
        }

        return res;
    }
}  
