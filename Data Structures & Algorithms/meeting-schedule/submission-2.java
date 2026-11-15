/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> a.start-b.start);
        int len = intervals.size();
        for(int i=1;i<len;i++) {
            if(intervals.get(i-1).end > intervals.get(i).start) 
                return false;
        }
        return true;
    }
}
