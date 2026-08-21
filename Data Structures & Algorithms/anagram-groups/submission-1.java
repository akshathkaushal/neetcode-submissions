class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> strMap = new HashMap<>();
        for(String s : strs) {
            int[] chars = new int[26];

            for(char c: s.toCharArray()) 
                chars[c-'a']++;

            String hash = Arrays.toString(chars);
            strMap.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(strMap.values());
    }
}
