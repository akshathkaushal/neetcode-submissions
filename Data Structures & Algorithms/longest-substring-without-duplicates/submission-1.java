class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> alpha = new HashMap<>();
        int res=0, cur=-1;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(alpha.containsKey(c)) {
                cur = Math.max(cur,alpha.get(c));
            }

            // update the new position of the character
            alpha.put(c,i);

            res = Math.max(res,i-cur);
        }
        return res;
    }
}
