class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() > text2.length()) 
            return longestCommonSubsequence(text2,text1);
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<text1.length();i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(text1,text2,0,0,dp);
    }
    private int helper(String text1, String text2, int x1, int x2, int[][] dp) {
        if(x1 == text1.length() || x2 == text2.length()) return 0;
        if(dp[x1][x2] != -1) 
            return dp[x1][x2];

        if(text1.charAt(x1) == text2.charAt(x2)) 
            return dp[x1][x2] = 1+helper(text1,text2,x1+1,x2+1,dp);
        return dp[x1][x2] = Math.max(
            helper(text1,text2,x1+1,x2,dp),
            helper(text1,text2,x1,x2+1,dp));
    }
}
