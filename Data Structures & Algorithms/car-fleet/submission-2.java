class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] arr = new int[n][2];    

        for(int i=0;i<n;i++) {
            arr[i][0]=position[i];
            arr[i][1]=speed[i];
        }

        Arrays.sort(arr, (a,b) -> Integer.compare(b[0],a[0]));

        Stack<Double> stk = new Stack<>();

        for(int[] car : arr) {
            stk.push((double)(target-car[0])/car[1]);
            if(stk.size()>=2 && stk.peek() <= stk.get(stk.size()-2)) {
                stk.pop();
            }
        }

        return stk.size();
    }
}
