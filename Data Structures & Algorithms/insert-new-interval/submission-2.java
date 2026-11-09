class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int i=0, len=intervals.length;
        while(i<len && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        int min=newInterval[0], max=newInterval[1];
        while(i<len && intervals[i][0] <= max) {
            min = Math.min(min,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
            i++;
        }
        ans.add(new int[]{min,max});
        while(i<len) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
