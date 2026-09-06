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
        // digToLet.forEach((k,v) -> {
        //     System.out.println(k + ":" + v);
        // });
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
        char c = digits.charAt(idx);
        // System.out.println("Key is: "+c);
        // System.out.println("Value is: "+digToLet.get(c));
        for(int i=0;i<digToLet.get(c).length();i++) {
            helper(digits,idx+1,temp+digToLet.get(c).charAt(i));
        }
    }
}
