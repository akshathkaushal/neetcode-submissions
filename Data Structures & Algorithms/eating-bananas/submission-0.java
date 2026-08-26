class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m = -1;
        for(int i:piles) m = Math.max(i,m);

        int l=1, r=m;
        while(l<r) {
            int mid = l+(r-l)/2;
            int ans = 0;
            for(int i:piles) ans += Math.ceil((double)i/mid);

            if(ans>h) l=mid+1;
            else r=mid;
        }
        return l;
    }
}
