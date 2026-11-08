class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) 
            Arrays.fill(dp[i],-1);
        
        return helper(s,0,t,0,dp);
    }
    private int helper(String s, int p1, String t, int p2, int[][] dp) {
        if(p2 == t.length()) return 1; // empty string
        else if(p1 == s.length()) return 0; // no strings

        if(dp[p1][p2] != -1) return dp[p1][p2];

        int chosen = 0, notChosen = 0;
        if(s.charAt(p1) == t.charAt(p2)) {
            chosen = helper(s,p1+1,t,p2+1,dp);
        }
        notChosen = helper(s,p1+1,t,p2,dp);

        return dp[p1][p2] = chosen+notChosen;

    }
}
