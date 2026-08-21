class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> strMap = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String hash = new String(ch);
            strMap.computeIfAbsent(
                hash, k -> new ArrayList<>()
                ).add(s);
        }
        return new ArrayList<>(strMap.values());
    }
}
