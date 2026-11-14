class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> freqS = new HashMap<>();
        Map<Character,Integer> freqT = new HashMap<>();

        for(char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c,0)+1);
        }

        int l=0,r=0,start=-1,end=-1;
        String res = "";

        while(r<s.length()) {
            char c = s.charAt(r);
            freqS.put(c,freqS.getOrDefault(c,0)+1);

            while(compareFreq(freqS,freqT)) {
                if(res.isEmpty() || r-l+1<res.length()) {
                    start=l;
                    end=r;
                }
                c = s.charAt(l);
                freqS.put(c,freqS.get(c)-1);
                l++;
            }

            if(start != -1 && end != -1) {
                res = s.substring(start,end+1);
            }
            r++;
        }

        return res;
    }

    private boolean compareFreq(
        Map<Character,Integer> freqS, 
        Map<Character,Integer> freqT) {
            for(Character c : freqT.keySet()) {
                if(!freqS.containsKey(c) || freqS.get(c) < freqT.get(c)) 
                    return false;
            }
            return true;
        }
}
