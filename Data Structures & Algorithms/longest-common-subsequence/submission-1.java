class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return helper(text1,0,text2,0,dp);
    }
    private int helper(String text1, int idx1, String text2, int idx2, int[][] dp) {
        if(idx1==text1.length() || idx2==text2.length()) return 0;
        
        if(dp[idx1][idx2] != 0) return dp[idx1][idx2];


        if(text1.charAt(idx1) == text2.charAt(idx2)) {
            return dp[idx1][idx2] = 1+helper(text1,idx1+1,text2,idx2+1,dp);
        }
        return dp[idx1][idx2] = Math.max(
            helper(text1,idx1+1,text2,idx2,dp),
            helper(text1,idx1,text2,idx2+1,dp)
        );
    }
}
