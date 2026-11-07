// Map<String,Char> map = new HashMap<>();
        // map.put("1",'A');
        // map.put("2",'B');
        // map.put("3",'C');
        // map.put("4",'D');
        // map.put("5",'E');
        // map.put("6",'F');
        // map.put("7",'G');
        // map.put("8",'H');
        // map.put("9",'I');
        // map.put("10",'J');
        // map.put("11",'K');
        // map.put("12",'L');
        // map.put("13",'M');
        // map.put("14",'N');
        // map.put("15",'O');
        // map.put("16",'P');
        // map.put("17",'Q');
        // map.put("18",'R');
        // map.put("19",'S');
        // map.put("20",'T');
        // map.put("21",'U');
        // map.put("22",'V');
        // map.put("23",'W');
        // map.put("24",'X');
        // map.put("25",'Y');
        // map.put("26",'Z');
        
class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(s,0,dp);
    }
    private int helper(String s, int idx, int[] dp) {
        if(idx >= s.length()) return 1;
        if(s.charAt(idx) == '0') return 0;

        if(dp[idx] != -1) return dp[idx];

        // check validity of position
        // 1, or 2(x<6) 
        if(idx+1 < s.length()) {
            if(s.charAt(idx) == '1' || 
                (s.charAt(idx)=='2' && s.charAt(idx+1)-'0' <= 6)) {
                return dp[idx] = helper(s,idx+1,dp)+helper(s,idx+2,dp);
            }
        } 
        return dp[idx] = helper(s,idx+1,dp);
    }
}
