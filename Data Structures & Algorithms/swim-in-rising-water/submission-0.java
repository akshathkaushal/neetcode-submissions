class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(arr[i],Integer.MAX_VALUE);

        // {dist, i, j}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[0],b[0]);
        });

        // we are standing at 0,0
        arr[0][0] = grid[0][0];
        pq.add(new int[]{arr[0][0],0,0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!pq.isEmpty()) {
            int[] qTop = pq.poll();
            int dist = qTop[0];
            int i = qTop[1];
            int j = qTop[2];

            if(i == n-1 && j== m-1) return dist;

            for(int k=0;k<4;k++) {
                int x = i+dirs[k][0];
                int y = j+dirs[k][1];

                // check new position validity
                if(x>=0 && x<n && y>=0 && y<m) {
                    int newDist = Math.max(dist,grid[x][y]);
                    if(newDist < arr[x][y]) {
                        arr[x][y] = newDist;
                        pq.add(new int[]{newDist,x,y});
                    }
                }
            }
        }

        return -1;
    }
}
