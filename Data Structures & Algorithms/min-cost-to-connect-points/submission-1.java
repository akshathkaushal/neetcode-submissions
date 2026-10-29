class DSU {
    private int[] parent;
    private int[] size;

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
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<int[]> edges = new ArrayList<>();
        int n = points.length;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n && j!=i;j++) {
                int dist = Math.abs(points[i][0]-points[j][0])+
                Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        
        Collections.sort(edges, (a,b) -> {
            return Integer.compare(a[2],b[2]);
        });

        DSU dsu = new DSU(n);

        int ans = 0;
        int numEdges = 0;
        for(int[] edge : edges) {
            if(numEdges == n-1) break;
            int a = edge[0];
            int b = edge[1];
            int size = edge[2];
            
            if(dsu.find(a) != dsu.find(b)) {
                dsu.union(a,b);
                ans += size;
                numEdges++;
            }
        }

        return ans;
    }
}
