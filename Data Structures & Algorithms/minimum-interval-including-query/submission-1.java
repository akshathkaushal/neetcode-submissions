class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b) -> {
            int comp=Integer.compare(a[0],b[0]);
            if(comp==0) return Integer.compare(a[1],b[1]);
            return comp;
        });

        int n = queries.length;
        int[] res = new int[n];

        List<int[]> queriesS = new ArrayList<>();
        for(int i=0;i<n;i++) queriesS.add(new int[]{queries[i],i});

        Collections.sort(queriesS, (a,b) -> a[0]-b[0]);

        // Store {length, endpoint} for any interval
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int comp = Integer.compare(a[0],b[0]);
            if(comp == 0) return Integer.compare(a[1],b[1]);
            return comp;
        });

        int idxQ=0, idxI=0;

        while(idxQ < queriesS.size()) {
            
            // first: add all the valid intervals
            while(idxI<intervals.length && intervals[idxI][0] <= queriesS.get(idxQ)[0]) {
                pq.add(new int[]{
                    intervals[idxI][1]-intervals[idxI][0]+1,
                    intervals[idxI][1]
                });

                idxI++;
            }

            // second: remove all the invalid intervals
            while(!pq.isEmpty() && pq.peek()[1] < queriesS.get(idxQ)[0]) 
                pq.poll();

            if(!pq.isEmpty())
                res[queriesS.get(idxQ)[1]] = pq.peek()[0];
            else 
                res[queriesS.get(idxQ)[1]] = -1;

            idxQ++;
        }
        return res;

    }
}
