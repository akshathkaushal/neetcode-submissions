class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for(String s : strs) {
            str.append(Integer.toString(s.length()));
            str.append("#");
            str.append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        int ptr=0, len = str.length();
        List<String> res = new ArrayList<>();
        while(ptr < len) {
            // find length which is the first integer until delimiter
            int ptr1=ptr;
            while(str.charAt(ptr1) != '#') ptr1++;
            int strlen = Integer.parseInt(str.substring(ptr,ptr1));
            StringBuilder strb = new StringBuilder();
            int j=ptr1+1;
            for(int k=0;k<strlen;k++) {
                strb.append(str.charAt(j++));
            }
            ptr=j;
            res.add(strb.toString());
        }
        return res;
    }
}
