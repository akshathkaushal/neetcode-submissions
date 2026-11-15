class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        int l,r;
        String res = "";
        for(int i=0;i<len;i++) {
            l=i;
            r=i;
            while(l>=0 && r<len && s.charAt(l) == s.charAt(r)) {
                if(r-l+1>res.length()) {
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            l=i;
            r=i+1;
            while(l>=0 && r<len && s.charAt(l) == s.charAt(r)) {
                if(r-l+1>res.length()) {
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
