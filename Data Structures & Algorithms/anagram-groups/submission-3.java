class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String s:strs) {
            String key = getKey(s);
            if(!map.containsKey(key)) {
                map.put(key,new ArrayList<>());
                
            }
            map.get(key).add(s);
        }
        map.forEach((key,val) -> {
            result.add(val);
        });
        return result;
    }
    private String getKey(String s) {
        int[] arr = new int[26];
        for(char c:s.toCharArray()) {
            arr[c-'a']++;
        }
        StringBuilder str = new StringBuilder();
        for(int i=0;i<26;i++) {
            str.append((char)('a'+arr[i]));
            str.append(',');
        }
        return str.toString();
    }
}
