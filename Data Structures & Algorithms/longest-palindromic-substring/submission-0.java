class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();

        String res = "";
        for(int i=0;i<len;i++) {
            // odd length substring
            int l=i, r=i;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                int curLen = r-l+1;
                if(curLen > res.length()) {
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }

            // even length substring
            l=i;
            r=i+1;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                int curLen = r-l+1;
                if(curLen > res.length()) {
                    res = s.substring(l,r+1);
                }
                l--;
                r++;
            }
        }
        return res;
    }
}
