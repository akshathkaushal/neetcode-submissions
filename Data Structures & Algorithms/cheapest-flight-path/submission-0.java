class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        // construct adjacency list of graph
        // src -> [{dest,price}]
        for(int[] info : flights) {
            adj.get(info[0]).add(new int[]{info[1],info[2]});
        }

        // maintain prices array
        int[][] prices = new int[n][k+2];
        for(int i=0;i<n;i++) {
            Arrays.fill(prices[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0],b[0]); // compare price
        });

        // price, hops, airport
        que.add(new int[]{0,0,src});
        prices[src][0] = 0;

        int res = Integer.MAX_VALUE;
        while(!que.isEmpty()) {
            int[] qTop = que.poll();
            int price = qTop[0];
            int hops = qTop[1];
            int airport = qTop[2];

            if(price > prices[airport][hops]) {
                continue;
            }
            if(airport == dst) return price;

            if(hops == k+1) {
                continue;
            }

            // iterate thru next stops
            for(int[] next : adj.get(airport)) {
                int nextAirport = next[0];
                int nextPrice = price+next[1];
                int nextFlights = hops+1;

                if(nextPrice < prices[nextAirport][nextFlights]) {
                    prices[nextAirport][nextFlights] = nextPrice;

                    que.add(new int[]{nextPrice, nextFlights, nextAirport});
                }
            }
        }

        return -1; 
    }
}
