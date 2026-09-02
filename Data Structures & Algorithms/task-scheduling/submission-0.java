class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        int[] taskFreq = new int[26];
        for(char task:tasks) {
            taskFreq[task-'A']++;
        }

        for(int f : taskFreq) {
            if(f>0) que.add(f);
        }

        int time=0;
        while(!que.isEmpty()) {
            List<Integer> updatedTasks = new ArrayList<>();
            for(int i=0;i<=n;i++) { // taking n+1 tasks
                if(!que.isEmpty()) {
                    int t = que.poll();
                    updatedTasks.add(--t);
                }
            }

            for(int ut: updatedTasks) {
                if(ut>0) que.add(ut);
            }

            if(que.isEmpty()) {
                time += updatedTasks.size();
            } else {
                time += n+1;
            }
        }
        return time;
    }
}
