class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftPStk = new Stack<>();
        Stack<Integer> starStk = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c == '(') {
                leftPStk.push(i);
            } else if(c == ')') {
                if(!leftPStk.isEmpty()) {
                    leftPStk.pop();
                } else if(!starStk.isEmpty()) {
                    starStk.pop();
                } else {
                    return false;
                }
             } else { // *
                starStk.push(i);
            }
        }
        while(!leftPStk.isEmpty() && !starStk.isEmpty()) {
            if(leftPStk.pop() > starStk.pop()) return false;
        }
        return leftPStk.isEmpty();
    }
}
