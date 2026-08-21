class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> strMap = new HashMap<>();
        for(String s : strs) addToMap(s,strMap);

        List<List<String>> res = new ArrayList<>();
        strMap.forEach((key,val) -> {
            res.add(val);
        });

        return res;
    }
    private void addToMap(String s, HashMap<String,List<String>> strMap) {
        int[] chars = new int[26];

        for(int i=0;i<s.length();i++) chars[s.charAt(i)-'a']++;

        String hash = "";
        for(int i=0;i<26;i++) hash += (char)('a'+i)+chars[i];

        strMap.computeIfAbsent(hash, k -> new ArrayList<>()).add(s);
    }
}
