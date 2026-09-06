class Solution {
    private Map<Character,String> digToLet = Map.of(
        '2', "abc",
        '3', "def",
        '4', "ghi",
        '5', "jkl",
        '6', "mno",
        '7', "pqrs",
        '8', "tuv",
        '9', "wxyz"
    );
    private List<String> res;
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return Collections.emptyList();
        
        res = new ArrayList<>();
        helper(digits,0, "");
        return res; 
    }
    private void helper(String digits, int idx, String temp){
        if(idx == digits.length()) {
            res.add(new String(temp));
            return;
        }
        for(char c : digToLet.get(digits.charAt(idx)).toCharArray()) {
            helper(digits,idx+1,temp+c);
        }
    }
}
