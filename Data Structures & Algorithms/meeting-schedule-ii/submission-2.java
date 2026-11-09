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
        pq.add(intervals.get(0).end);
        for(int i=1;i<len;i++) {
            Interval cur = intervals.get(i);
            if(pq.peek() <= cur.start) {
                pq.poll();
            }
            pq.offer(cur.end);
        }
        return pq.size();
    }
}
