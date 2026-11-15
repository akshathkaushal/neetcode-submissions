class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i=0, len=intervals.length;
        while(i<len && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        int minVal=newInterval[0], maxVal=newInterval[1];
        while(i<len && intervals[i][0] <= maxVal) {
            minVal = Math.min(minVal,intervals[i][0]);
            maxVal = Math.max(maxVal,intervals[i][1]);
            i++;
        }

        result.add(new int[]{minVal,maxVal});

        while(i<len) {
            result.add(intervals[i++]);
        }

        return result.toArray(new int[result.size()][]);

    }
}
