class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] prev = intervals[0];
        int len = intervals.length;
        int count=0;
        for(int i=1;i<len;i++) {
            if(intervals[i][0] < prev[1]) {
                count++;
                if(prev[1]>intervals[i][1]) prev = intervals[i];
            } else {
                prev = intervals[i];
            }
        }

        return count;
    }
}
