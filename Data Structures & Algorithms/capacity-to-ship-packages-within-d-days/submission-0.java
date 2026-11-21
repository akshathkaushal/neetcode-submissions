class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min=0,max=0, len=weights.length;
        for(int i=0;i<len;i++) {
            if(weights[i] > min) {
                min=weights[i];
            }
            max+=weights[i];
        }
        int ans = 0;
        while(min <= max) {
            int mid = (min+max)/2;

            if(calcDays(weights,mid,days)) {
                ans = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return ans;
    }
    private boolean calcDays(int[] weights, int cap, int days) {
        int cur=0, total=1;
        for(int i=0;i<weights.length;i++) {
            if(cur+weights[i] <= cap) {
                 cur += weights[i];
            } else {
                total++;
                cur=weights[i];
            }

            if(total > days) return false;
        }
        return true;
    }
}