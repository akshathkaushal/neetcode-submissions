class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stk = new Stack<>();
        for(String s: tokens) {
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                String num2 = stk.peek();
                stk.pop();
                String num1 = stk.peek();
                stk.pop();
                stk.add(Integer.toString(process(num1,num2,s)));
            } else {
                stk.push(s);
            }
        }
        return Integer.parseInt(stk.peek());
    }
    private int process(String num1, String num2, String op) {
        if(op.equals("+")) {
            return Integer.parseInt(num1) + Integer.parseInt(num2);
        } else if(op.equals("*")) {
            return Integer.parseInt(num1) * Integer.parseInt(num2);
        } else if(op.equals("-")) {
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        } else if(op.equals("/")) {
            if(num2.equals("0")) return Integer.MAX_VALUE;
            return Integer.parseInt(num1) / Integer.parseInt(num2);
        }
        return 0;
    }
}
