class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        int len = digits.length;
        for(int i=len-1;i>=0;i--) {
            int sum = digits[i]+carry;
            digits[i] = sum%10;
            carry = sum/10;
        }

        if(carry != 0) {
            int[] res = new int[len+1];
            res[0]=carry;
            for(int i=1;i<=len;i++) {
                res[i] = digits[i-1];
            }
            return res;
        }
        int[] res = new int[len];
        for(int i=0;i<len;i++) {
            res[i] = digits[i];
        }
        return res;
    }
}
