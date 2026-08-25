class Solution {
    public String minWindow(String s, String t) {
        // Create freq arrays
        int[] freqS = new int[128];
        int[] freqT = new int[128];

        for(char c: t.toCharArray()) freqT[c]++;

        int l=0, r=0;
        String res="";

        while(r < s.length()) {
            freqS[s.charAt(r)]++;
            while(compareFreq(freqS,freqT)) {
                if(res.isEmpty() || r - l + 1 < res.length()) {
                    res = s.substring(l, r + 1);
                }
                freqS[s.charAt(l)]--;
                l++;
            }
            r++;
        }

        return res;
    }
    private boolean compareFreq(int[] freqS, int[] freqT) {
        for(int i=0;i<128;i++) {
            if(freqS[i] < freqT[i]) return false;
        }
        return true;
    }
}
