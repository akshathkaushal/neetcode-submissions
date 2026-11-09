class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int n = gas.length;
        for(int i=0;i<n;i++) {
            curSum += (gas[i]-cost[i]);
        }
        if(curSum<0) return -1;
        
        curSum=0;
        int idx=0;
        for(int i=0;i<n;i++) {
            curSum+=(gas[i]-cost[i]);
            if(curSum<0) {
                idx=i+1;
                curSum=0;
            }
        }
        return idx%n;
    }
}
