class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int n) {
        if(n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py) return;

        if(size[px] < size[py]) {
            parent[px] = py;
            size[py] += size[px];
        } else {
            parent[py] = px;
            size[px] += size[py];
        }
    }

    int getSize(int n) {
        return size[n];
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        DSU dsu = new DSU(n*m);

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    int p1 = i*m+j;

                    for(int[] dir : dirs) {
                        int x = i+dir[0];
                        int y = j+dir[1];

                        if(x>=0 && x<n && y>=0 && y<m && grid[x][y] == 1) {
                            int p2 = x*m+y;
                            dsu.union(p1,p2);
                        }
                    }
                }
            }
        }

        int res = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    res = Math.max(res,dsu.getSize(dsu.find(i*m+j)));
                }
            }
        }

        return res;
    }
}
