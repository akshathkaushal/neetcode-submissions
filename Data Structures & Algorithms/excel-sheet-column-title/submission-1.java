class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while(columnNumber > 0) {
            int x = columnNumber%26;
            System.out.println(Integer.toString(x)+','+Integer.toString(columnNumber/26));
            if(x>0) {
                str.append((char)('A'+x-1));
            } else {
                str.append((char)('Z'));
                columnNumber--;
            }
            columnNumber /= 26;
        }
        return str.reverse().toString();
    }
}