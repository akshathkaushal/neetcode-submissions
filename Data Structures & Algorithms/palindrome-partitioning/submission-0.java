class Solution {
    private List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        helper(s,0,new ArrayList<>());
        return res;
    }
    private void helper(String s, int idx, List<String> temp) {
        if(idx == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=idx;i<s.length();i++) {
            if(isPalindrome(s,idx,i)) {
                temp.add(s.substring(idx,i+1));
                helper(s,i+1,temp);
                temp.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
