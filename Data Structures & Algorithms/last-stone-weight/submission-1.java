class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones) {
            que.add(stone);
        }

        while(que.size()>1) {
            int stone1 = que.poll();
            int stone2 = que.poll();

            if(stone1!=stone2) {
                que.add(stone1-stone2);
            }
        }

        return (que.isEmpty()) ? 0 : que.peek();
    }
}
