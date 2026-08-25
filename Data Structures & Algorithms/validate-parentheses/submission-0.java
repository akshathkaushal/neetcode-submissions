class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> chars = new HashMap<>();
        chars.put(')','(');
        chars.put('}','{');
        chars.put(']','[');

        Stack<Character> stk = new Stack<>();

        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') stk.push(c);
            else {
                if(!stk.isEmpty() && chars.get(c) == stk.peek()) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
