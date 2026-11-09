class Solution {
    public double myPow(double x, int n) {
        if(n<0) {
            n *= (-1);
            x=1/x;
        }

        double ans = 1;
        while(n!=0) {
            if((n&1) != 0) {
                ans *= x;
            }
            x*=x;
            n/=2;
        }
        return ans;
    }
}
