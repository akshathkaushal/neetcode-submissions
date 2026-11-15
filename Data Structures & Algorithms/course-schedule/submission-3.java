class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(dfs(adj,i,visited,pathVisited)) return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adj, int course, boolean[] visited, boolean[] pathVisited) {
        // if course was visited in the current path
        // return true
        if(pathVisited[course]) 
            return true;
        
        // if the course was not visited in the current path
        // but was visited before, means there is no cycle
        // so return false
        if(visited[course])  
            return false;

        visited[course] = true;

        pathVisited[course] = true;
        for(int next : adj.get(course)) {
            if(dfs(adj,next,visited,pathVisited)) 
                return true;
        }
        pathVisited[course] = false;
        
        return false;
    }
}
