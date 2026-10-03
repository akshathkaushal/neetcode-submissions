class DSU {
    int[] parent;
    int[] size;

    public DSU(int n){
        parent = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i]=i;
            size[i]=1;
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
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        
        int[] res = new int[]{-1,-1};
        for(int[] edge : edges) {
            if(dsu.find(edge[0]) == dsu.find(edge[1])){
                res[0]=edge[0];
                res[1]=edge[1];
            } else {
                dsu.union(edge[0],edge[1]);
            }
        }       
        return res;
    }
}
