class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        
        boolean ans = dfs(adj,0,-1,visited,pathVisited);
        if(ans) return false;

        for(int i=0;i<n;i++) 
            if(!visited[i]) return false;

        return true;
    }
    private boolean dfs(List<List<Integer>> adj, int idx, int pIdx, boolean[] visited, boolean[] pathVisited) {
        if(pathVisited[idx]) return true;
        if(visited[idx]) return false;

        visited[idx]=true;
        pathVisited[idx]=true;
        for(int next : adj.get(idx)) {
            if(next != pIdx && dfs(adj,next,idx,visited,pathVisited)) 
                return true;
        }
        pathVisited[idx]=false;
        return false;
    }
}
