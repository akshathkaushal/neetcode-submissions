class Solution {
    private List<String> res;
    public List<String> generateParenthesis(int n) {
        int open=0, close=0;
        res = new ArrayList<>();
        helper(n,open,close, "");
        return res;
    }
    private void helper(int n, int open, int close, String cur) {
        if(open == n && close == n) {
            res.add(new String(cur));
            return;
        }

        if(open>n || close>n || close>open) return;

        helper(n,open+1,close,cur+"(");
        helper(n,open,close+1,cur+")");
    }
}
