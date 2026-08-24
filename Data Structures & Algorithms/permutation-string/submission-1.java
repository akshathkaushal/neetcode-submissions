class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1Char = new int[26];
        for(char c : s1.toCharArray()) s1Char[c-'a']++;

        int[] target = new int[26];
        for(int i=0;i<s1.length();i++) target[s2.charAt(i)-'a']++; 

        int r=s1.length();
        while(r<s2.length()) {
            if(Arrays.equals(target,s1Char)) return true;

            target[s2.charAt(r-s1.length())-'a']--;
            target[s2.charAt(r)-'a']++;
            r++;
        }
        if(Arrays.equals(target,s1Char)) return true;
        return false;
    }
}
