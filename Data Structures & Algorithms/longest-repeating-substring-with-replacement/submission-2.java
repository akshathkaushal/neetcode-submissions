class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        int res=0;
        int l=0, maxFreq=0;
        for(int r=0;r<s.length();r++) {
            char c = s.charAt(r);
            charMap.put(c,charMap.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, charMap.get(c));

            while((r-l+1)-maxFreq > k) {
                c = s.charAt(l);
                charMap.put(c, charMap.get(c)-1);
                l++;
            }

            res = Math.max(res,r-l+1);
        }

        return res;
    }
}
