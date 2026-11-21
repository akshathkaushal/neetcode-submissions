class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        PriorityQueue<long[]> inUse = new PriorityQueue<>((a,b) -> {
            int time = Long.compare(a[0],b[0]);
            if(time == 0) {
                return Long.compare(a[1],b[1]);
            }
            return time;
        });

        // mark room available
        for(int i=0;i<n;i++) rooms.add(i);
        
        // freq array
        int[] freq = new int[n];

        // iterate the meetings
        for(int[] meeting : meetings) {
            // empty the eligible used rooms before
            while(!inUse.isEmpty() && inUse.peek()[0] <= meeting[0]) {
                rooms.add((int)inUse.poll()[1]);
            }

            Integer endTime;
            Integer room; 

            // assign the new rooms
            if(rooms.size()>0) {
                room = rooms.poll();
                endTime = meeting[1]; 
            } else {
                long[] earliest = inUse.poll();
                room = (int) earliest[1];
                endTime = (int) earliest[0] + (meeting[1]-meeting[0]);
            }

            inUse.offer(new long[]{endTime,room});
            freq[room]++;
        }

        int max=0,ans=-1;
        for(int i=0;i<n;i++) {
            if(freq[i]>max) {
                max=freq[i];
                ans=i;
            }
        }

        return ans;
    }
}