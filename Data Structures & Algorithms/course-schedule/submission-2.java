class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());

        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i=0;i<numCourses;i++) {
            if(dfs(i,adj,vis,pathVis)) return false;
        }

        return true;
    }
    private boolean dfs(int course, 
    ArrayList<ArrayList<Integer>> adj,
    boolean[] vis, boolean[] pathVis) {
        // if course came again in current path
        if(pathVis[course]) return true;

        // if course visited before
        if(vis[course]) return false;

        vis[course] = true;
        pathVis[course] = true;
        for(int next : adj.get(course)) {
            if(dfs(next,adj,vis,pathVis)) return true;
        }
        pathVis[course] = false;
        return false;
    }
}
