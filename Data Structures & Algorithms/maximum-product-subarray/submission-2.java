class Solution {
    public int maxProduct(int[] nums) {
        int pref=1,suff=1, prod=Integer.MIN_VALUE, len=nums.length;
        for(int i=0;i<len;i++) {
            if(pref==0) pref=1;
            if(suff==0) suff=1;

            pref *= nums[i];
            suff *= nums[len-i-1];
            prod = Math.max(prod,Math.max(pref,suff));
        }
        return prod;
    }
}
