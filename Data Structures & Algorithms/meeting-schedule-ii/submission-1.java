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
    public int minMeetingRooms(List<Interval> intervals) {
        int len = intervals.size();
        if(len==0) return 0;
        Collections.sort(intervals, (a,b) -> a.start-b.start);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval cur : intervals) {
            if(!pq.isEmpty() && pq.peek() <= cur.start) {
                pq.poll();
            }
            pq.offer(cur.end);
        }
        return pq.size();
    }
}
