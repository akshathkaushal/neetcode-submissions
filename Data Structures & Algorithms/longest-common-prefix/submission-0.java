class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx=0, minLen=Integer.MAX_VALUE;
        int len = strs.length;
        for(int i=0;i<len;i++) 
            minLen = Math.min(minLen,strs[i].length());
        
        boolean check = true;
        while(idx < minLen) {
            for(int i=1;i<len;i++) {
                if(strs[i].charAt(idx) != strs[i-1].charAt(idx)) {
                    check=false;
                    break;
                }
            }
            if(!check) return strs[0].substring(0,idx);
            idx++;
        }

        return strs[0].substring(0,idx);
    }
}