class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> result = new ArrayList<>();
        int i=0, len=intervals.length;

        while(i<len) {
            int s = result.size();
            if(s==0 || intervals[i][0] > result.get(s-1)[1]) {
                result.add(intervals[i]);
            } else {
                result.get(s-1)[1] = Math.max(result.get(s-1)[1],intervals[i][1]);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
