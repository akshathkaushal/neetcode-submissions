class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) que.add(i);
        }
        int[] result = new int[numCourses];
        int idx=0;
        while(!que.isEmpty()) {
            int course = que.poll();
            result[idx++]=course;
            for(int next : adj.get(course)) {
                indegree[next]--;
                if(indegree[next]==0) que.add(next);
            }
        }
        
        if(idx != numCourses) 
            return new int[0];
        return result;
    }
}
