class Solution {
    public boolean isMatch(String s, String p) {
        int sLen=s.length(), pLen=p.length();
        int[][] dp = new int[sLen+1][pLen+1];
        for(int i=0;i<=sLen;i++) {
            Arrays.fill(dp[i],-1);
        }

        return helper(s,p,0,0,dp);
    }
    private boolean helper(String s, String p, int p1, int p2, int[][] dp) {
        if(p2 == p.length()) return (p1 == s.length());

        if(dp[p1][p2] != -1) return dp[p1][p2] == 1;

        boolean ans = false;

        boolean match = (p1<s.length()) && 
        (s.charAt(p1)==p.charAt(p2) || p.charAt(p2) == '.');
        
        if(p2+1<p.length() && p.charAt(p2+1) == '*') {
            ans = helper(s,p,p1,p2+2,dp) || 
            (match && helper(s,p,p1+1,p2,dp));
        } else {
            ans = match && helper(s,p,p1+1,p2+1,dp);
        }

        dp[p1][p2] = (ans) ? 1 : 0;
        return ans;
    }
}
