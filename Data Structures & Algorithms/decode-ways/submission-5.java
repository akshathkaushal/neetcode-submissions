class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }
    private int helper(String s, int idx, int[] dp) {
        if(idx>=s.length()) return 1;
        if(s.charAt(idx)=='0') return 0;

        if(dp[idx] != -1) return dp[idx];

        if(idx+1<s.length()) {
            if(s.charAt(idx)=='1' || (s.charAt(idx)=='2' && s.charAt(idx+1)<='6'))
            return dp[idx] = helper(s,idx+1,dp)+helper(s,idx+2,dp);
        }
        return dp[idx] = helper(s,idx+1,dp);
    }
}
