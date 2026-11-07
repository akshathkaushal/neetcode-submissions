class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int cnt=0;
        int l=-1, r=-1;
        for(int i=0;i<n;i++) {
            // check for odd length palindromes
            l = i;
            r = i;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }

            // check for even length palindromes
            l=i;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)) {
                cnt++;
                l--;
                r++;
            }
        }

        return cnt;
    }
}
