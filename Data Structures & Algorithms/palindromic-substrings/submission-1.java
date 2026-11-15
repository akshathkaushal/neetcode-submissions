class Solution {
    public int countSubstrings(String s) {
        int l,r,len=s.length();
        int count=0;
        for(int i=0;i<len;i++) {
            l=i;
            r=i;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                count++;
                l--;
                r++;
            }
            l=i;
            r=i+1;
            while(l>=0 && r<len && s.charAt(l)==s.charAt(r)) {
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
