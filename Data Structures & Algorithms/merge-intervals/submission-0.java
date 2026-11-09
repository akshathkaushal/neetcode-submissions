class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            return Integer.compare(a[0],b[0]);
        });
        List<int[]> ans = new ArrayList<>();

        int min = intervals[0][0];
        int max = intervals[0][1];
        int len = intervals.length;
        for(int i=1;i<len;i++) {
            if(intervals[i][0] >= min && intervals[i][0] <= max) {
                max = Math.max(max,intervals[i][1]);
            } else {
                ans.add(new int[]{min,max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        ans.add(new int[]{min,max});

        return ans.toArray(new int[ans.size()][]);
    }
}
