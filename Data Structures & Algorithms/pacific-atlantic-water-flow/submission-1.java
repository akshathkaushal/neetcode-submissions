class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = null;
        // add x,y in queue
        Queue<int[]> que;
        int[][] target = new int[n][m];

        int dirs[][] = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // pacific
        visited = new boolean[n][m];
        que = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(!visited[i][0]) {
                target[i][0]++;
                que.add(new int[]{i,0});
                visited[i][0]=true;
            }
        }
        for(int j=0;j<m;j++) {
            if(!visited[0][j]) {
                target[0][j]++;
                que.add(new int[]{0,j});
                visited[0][j]=true;
            }
        }
        while(!que.isEmpty()) {
            int[] qTop = que.poll();
            int x = qTop[0], y=qTop[1];

            for(int[] dir : dirs) {
                int x1 = x+dir[0];
                int y1 = y+dir[1];

                if(x1>=0 && x1<n && y1>=0 && y1<m && !visited[x1][y1] && heights[x1][y1] >= heights[x][y]) {
                    que.add(new int[]{x1,y1});
                    target[x1][y1]++;
                    visited[x1][y1]=true;
                }
            }
        }

        // atlantic
        visited = new boolean[n][m];
        que = new LinkedList<>();
        for(int i=0;i<n;i++) {
            if(!visited[i][m-1]) {
                target[i][m-1]++;
                que.add(new int[]{i,m-1});
                visited[i][m-1]=true;
            }
        }
        for(int j=0;j<m;j++) {
            if(!visited[n-1][j]) {
                target[n-1][j]++;
                que.add(new int[]{n-1,j});
                visited[n-1][j]=true;
            }
        }
        while(!que.isEmpty()) {
            int[] qTop = que.poll();
            int x = qTop[0], y=qTop[1];

            for(int[] dir : dirs) {
                int x1 = x+dir[0];
                int y1 = y+dir[1];

                if(x1>=0 && x1<n && y1>=0 && y1<m && !visited[x1][y1] && heights[x1][y1] >= heights[x][y]) {
                    que.add(new int[]{x1,y1});
                    target[x1][y1]++;
                    visited[x1][y1]=true;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(target[i][j] == 2) result.add(new ArrayList<>(List.of(i,j)));
            }
        }

        return result;
    }
}
