class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) 
            Arrays.fill(dp[i],-1);

        return helper(word1,word2,0,0,dp);
    }
    private int helper(String word1, String word2, int p1, int p2, int[][] dp) {
        if(p1==word1.length()) return word2.length()-p2;
        if(p2==word2.length()) return word1.length()-p1;

        if(dp[p1][p2] != -1) return dp[p1][p2];

        // character matched
        if(word1.charAt(p1) == word2.charAt(p2)) {
            dp[p1][p2] = helper(word1,word2,p1+1,p2+1,dp);
        } else {
            int insert = helper(word1,word2,p1,p2+1,dp);
            int delete = helper(word1,word2,p1+1,p2,dp);
            int replace = helper(word1,word2,p1+1,p2+1,dp);

            dp[p1][p2] = 1+Math.min(insert,Math.min(delete,replace));
        }
        return dp[p1][p2];
    }
}
