class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber>0) {
            int letter = columnNumber % 26;
            int offset = (letter == 0) ? 25 : -1;
            sb.append((char)('A' + letter + offset));

            columnNumber = letter==0 ? 0 : columnNumber/26;
        }
        return sb.reverse().toString();
    }
}