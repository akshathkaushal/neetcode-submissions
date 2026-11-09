class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] maxI = new int[26];
        for(int i=0;i<s.length();i++) {
            maxI[s.charAt(i)-'a'] = Math.max(maxI[s.charAt(i)-'a'],i);
        }

        List<Integer> res = new ArrayList<>();
        int l=0,r=0;
        while(l<s.length()) {
            char c = s.charAt(l);
            r=maxI[c-'a'];
            int k=0;
            int count=0;
            while(k<r) {
                c = s.charAt(k);
                r = Math.max(r,maxI[c-'a']);
                k++;
            }
            res.add(r-l+1);
            l=r+1;
        }
        return res;
    }
}
