class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++) Arrays.fill(dp[i],-1);

        return helper(s1,s2,s3,0,0,0,dp);
    }
    private boolean helper(String s1, String s2, String s3, 
    int p1, int p2, int p3, int[][] dp) {
        if(p3 == s3.length()) {
            return p1 == s1.length() && p2 == s2.length();
        }

        if(dp[p1][p2] != -1) {
            return (dp[p1][p2] == 1) ? true : false;
        }

        boolean ans1 = false, ans2 = false;

        if(p1<s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            ans1 = helper(s1,s2,s3,p1+1,p2,p3+1,dp);
        }

        if(p2<s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            ans2 = helper(s1,s2,s3,p1,p2+1,p3+1,dp);
        }

        boolean ans = ans1 || ans2;
        dp[p1][p2] = (ans) ? 1 : 0;
        return ans;
    }
}
