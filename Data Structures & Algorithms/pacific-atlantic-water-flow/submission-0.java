class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = null;
        Queue<int[]> que = null;
        int[][] target = new int[n][m];

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        // Pacific
        visited = new boolean[n][m];
        que = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if(!visited[i][0]) {
                target[i][0]++;
                que.add(new int[]{i,0});
                visited[i][0] = true;
            }
        }
        for(int j=0;j<m;j++) {
            if(!visited[0][j]) {
                target[0][j]++;
                que.add(new int[]{0,j});
                visited[0][j] = true;
            }
        }
        while(!que.isEmpty()) {
            int[] qTop = que.poll();
            int x = qTop[0], y = qTop[1];

            for(int[] dir : dirs) {
                int _x = x+dir[0];
                int _y = y+dir[1];

                if(_x>=0 && _x<n && _y>=0 && _y<m && !visited[_x][_y] 
                && heights[_x][_y] >= heights[x][y]) {
                    que.add(new int[]{_x,_y});
                    target[_x][_y]++;
                    visited[_x][_y]=true;
                }
            }
        }

        // Atlantic
        visited = new boolean[n][m];
        que = new ArrayDeque<>();
        for(int i=0;i<n;i++) {
            if(!visited[i][m-1]) {
                target[i][m-1]++;
                que.add(new int[]{i,m-1});
                visited[i][m-1] = true;
            }
        }
        for(int j=0;j<m;j++) {
            if(!visited[n-1][j]) {
                target[n-1][j]++;
                que.add(new int[]{n-1,j});
                visited[n-1][j] = true;
            }
        }
        while(!que.isEmpty()) {
            int[] qTop = que.poll();
            int x = qTop[0], y = qTop[1];

            for(int[] dir : dirs) {
                int _x = x+dir[0];
                int _y = y+dir[1];

                if(_x>=0 && _x<n && _y>=0 && _y<m && !visited[_x][_y] 
                && heights[_x][_y] >= heights[x][y]) {
                    que.add(new int[]{_x,_y});
                    target[_x][_y]++;
                    visited[_x][_y]=true;
                }
            }
        }
        
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(target[i][j] == 2) {
                    res.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        return res;
    }
}
