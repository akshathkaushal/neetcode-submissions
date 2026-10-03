class Solution {
    public int orangesRotting(int[][] grid) {
        int freshFruits=0;
        Queue<int[]> que = new ArrayDeque<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    que.add(new int[]{i,j,0});
                } else if(grid[i][j] == 1) freshFruits++;
            }
        }
        int minVal = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!que.isEmpty()) {
            int[] qTop = que.poll();

            minVal = qTop[2];

            for(int[] dir : dirs) {
                int x = qTop[0] + dir[0];
                int y = qTop[1] + dir[1];

                if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1) {
                    grid[x][y] = 2;
                    que.add(new int[]{x,y,minVal+1});
                    freshFruits--;
                }
            }
        }

        if(freshFruits > 0) return -1;
        return minVal;
    }
}
