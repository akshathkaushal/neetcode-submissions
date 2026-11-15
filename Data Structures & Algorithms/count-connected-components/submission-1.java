class DSU {
    int[] parents;
    int[] size;

    public DSU(int n) {
        parents = new int[n+1];
        size = new int[n+1];
        for(int i=0;i<=n;i++) {
            parents[i]=i;
        }
    }

    public int find(int n) {
        if(n == parents[n]) return n;
        return parents[n] = find(parents[n]);
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(px == py) return ;

        if(size[px] < size[py]) {
            parents[px] = py;
            size[py] += size[px];
        } else {
            parents[py] = px;
            size[px] += size[py];
        }
    }

}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int count = 0;
        for(int[] edge : edges) {
            if(dsu.find(edge[0]) == dsu.find(edge[1])) continue;
            dsu.union(edge[0],edge[1]);
        }

        for(int i=0;i<n;i++) {
            if(dsu.find(i) == i) count++;
        }

        return count;
    }
}
