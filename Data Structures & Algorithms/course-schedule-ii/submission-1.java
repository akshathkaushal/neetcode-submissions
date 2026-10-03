class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> que = new ArrayDeque<>();

        // Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            if(inDegree[i] == 0) {
                que.add(i);
                res.add(i);
            }
        }

        while(!que.isEmpty()) {
            int qTop = que.poll();

            for(int next : adj.get(qTop)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    res.add(next);
                    que.add(next);
                }
            }
        }
        if(res.size() != numCourses) return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
