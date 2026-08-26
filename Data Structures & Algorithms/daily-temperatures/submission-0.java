class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();

        int n = temperatures.length;
        int[] res = new int[n];

        for(int i=0;i<n;i++) {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int tgt = stk.pop();
                res[tgt] = i-tgt;
            }

            stk.push(i);
        }

        return res;
    }
}
