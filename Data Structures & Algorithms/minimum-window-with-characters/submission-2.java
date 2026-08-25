class Solution {
    public String minWindow(String s, String t) {
        // Create freq arrays
        Map<Character,Integer> freqS = new HashMap<>();
        Map<Character,Integer> freqT = new HashMap<>();

        for(char c: t.toCharArray()) freqT.put(c,freqT.getOrDefault(c,0)+1);

        int l=0, r=0;
        String res="";

        int start=-1, end=-1;
        while(r < s.length()) {
            int val = freqS.getOrDefault(s.charAt(r),0);
            freqS.put(s.charAt(r),val+1);

            while(compareFreq(freqS,freqT)) {
                if(res.isEmpty() || r - l + 1 < res.length()) {
                    start = l;
                    end = r;
                }
                val = freqS.get(s.charAt(l));
                freqS.put(s.charAt(l),val-1);
                l++;
            }
            if(start != -1 && end != -1) 
                res = s.substring(start, end + 1);

            r++;
        }

        return res;
    }
    private boolean compareFreq(
        Map<Character,Integer> freqS, Map<Character,Integer> freqT) {
        for(Character key : freqT.keySet()) {
            if(!freqS.containsKey(key) || freqS.get(key) < freqT.get(key)) return false;
        }
        return true;
    }
}
