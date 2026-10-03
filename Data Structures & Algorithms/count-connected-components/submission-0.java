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
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for(int[] edge : edges) {
            dsu.union(edge[0],edge[1]);
        }
        int res = 0;
        for(int i=0;i<n;i++) {
            if(dsu.find(i)==i) res++;
        }
        return res;
    }
}
