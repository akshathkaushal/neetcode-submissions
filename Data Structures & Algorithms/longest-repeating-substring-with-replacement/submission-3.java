class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int l=0, maxF = 0, len = s.length();
        for(int r=0;r<len;r++) {
            char c = s.charAt(r);

            map.put(c,map.getOrDefault(c,0)+1);
            maxF = Math.max(maxF,map.get(c));

            while((r-l+1)-maxF > k) {
                c = s.charAt(l);
                map.put(c,map.get(c)-1);
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
