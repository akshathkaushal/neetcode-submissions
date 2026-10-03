class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                // if the current cell has treasure
                if(grid[i][j] == 0) {
                    // {i,j,minValue}
                    Queue<int[]> que = new ArrayDeque<>();
                    que.add(new int[]{i,j,0});
                    
                    while(!que.isEmpty()) {
                        int[] qTop = que.poll();
                        int val = qTop[2];

                        for(int[] dir : dirs) {
                            int x = qTop[0]+dir[0];
                            int y = qTop[1]+dir[1];
                            // iterate if it is a valid cell
                            if(x>=0 && x<n && y>=0 && y<m && grid[x][y]>1+val) {
                                grid[x][y] = 1+val;
                                que.add(new int[]{x,y,1+val});
                            }
                        }
                    }
                }
            }
        }
    }
}
