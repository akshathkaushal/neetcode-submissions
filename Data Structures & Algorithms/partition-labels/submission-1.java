class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] maxI = new int[26];
        for(int i=0;i<s.length();i++) {
            maxI[s.charAt(i)-'a'] = i;
        }

        List<Integer> res = new ArrayList<>();
        int l=0,r=0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            r = Math.max(r,maxI[c-'a']);
            if(r == i) {
                res.add(r-l+1);
                l=r+1;
            }
        }
        return res;
    }
}
