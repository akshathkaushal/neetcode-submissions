class Solution {
    public int numIslands(char[][] grid) {
        int numIslands=0;
        n=grid.length;
        m=grid[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid,i,j);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    private int n;
    private int m;
    private void dfs(char[][] grid, int x, int y) {
        if(x<0 || x>=n || y<0 || y>=m || grid[x][y]!='1') return;

        grid[x][y] = '0';
        dfs(grid,x+1,y);
        dfs(grid,x-1,y);
        dfs(grid,x,y+1);
        dfs(grid,x,y-1);
    }
}
