class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());

        for(int[] conn : times) {
            adj.get(conn[0]).add(new int[]{conn[1], conn[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1],b[1]);
        });

        pq.add(new int[]{k,0});

        int nodesCovered = 0;
        int[] time = new int[n+1];
        for(int i=1;i<=n;i++) time[i] = Integer.MAX_VALUE;
        time[k] = 0;
        while(!pq.isEmpty()) {
            int[] qTop = pq.poll();

            int curNode = qTop[0];
            int curTime = qTop[1];

            if(curTime > time[curNode]) continue;

            nodesCovered++;

            if(nodesCovered == n) return curTime;

            for(int[] node : adj.get(curNode)) {
                int nextNode = node[0];
                int nextTime = curTime + node[1];
                if(nextTime < time[nextNode]) {
                    time[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }

        return -1;
    }
}
