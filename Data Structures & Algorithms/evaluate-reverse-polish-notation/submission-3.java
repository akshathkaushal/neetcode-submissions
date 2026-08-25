class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                int num2 = stk.pop();
                int num1 = stk.pop();
                stk.add(process(num1,num2,s));
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        return stk.pop();
    }
    private int process(int num1, int num2, String op) {
        if(op.equals("+")) {
            return num1 + num2;
        } else if(op.equals("*")) {
            return num1 * num2;
        } else if(op.equals("-")) {
            return num1 - num2;
        } else if(op.equals("/")) {
            if(num2 == 0) return Integer.MAX_VALUE;
            return num1 / num2;
        }
        return 0;
    }
}
