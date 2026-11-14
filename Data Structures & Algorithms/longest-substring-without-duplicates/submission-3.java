class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> lastSeen = new HashMap<>();
        int ans = 0, len = s.length(), l=-1;
        for(int i=0;i<len;i++) {
            int lastPos = 0;
            char c = s.charAt(i);
            if(lastSeen.containsKey(c)) {
                lastPos = lastSeen.get(c);
                l = Math.max(l,lastPos);
            }
            lastSeen.put(c,i);
            ans = Math.max(ans,i-l);
            
        }
        return ans;
    }
}
