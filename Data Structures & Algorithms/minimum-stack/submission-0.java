class MinStack {
    private Stack<Integer> mainStk;
    private Stack<Integer> minStk;

    public MinStack() {
        mainStk = new Stack<>();
        minStk = new Stack<>();
    }
    
    public void push(int val) {
        mainStk.push(val);
        if(!minStk.isEmpty()) {
            minStk.push(Math.min(minStk.peek(), val));
        } else {
            minStk.push(val);
        }
    }
    
    public void pop() {
        if(!mainStk.isEmpty()) {
            mainStk.pop();
            minStk.pop();
        }
    }
    
    public int top() {
        if(!mainStk.isEmpty()) {
            return mainStk.peek();
        }
        return -1;
    }
    
    public int getMin() {
        if(!minStk.isEmpty()) {
            return minStk.peek();
        }
        return -1;
    }
}
