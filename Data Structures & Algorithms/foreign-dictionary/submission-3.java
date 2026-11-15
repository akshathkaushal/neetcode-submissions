class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,List<Character>> map = new HashMap<>();
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        for(String word : words) {
            for(char c:word.toCharArray()) {
                indegree[c-'a']=0;
                if(!map.containsKey(c)) map.put(c,new ArrayList<>());
            }
        }
        int numChars=0;
        for(int i=0;i<26;i++) if(indegree[i]==0) numChars++;

        int len = words.length;
        for(int i=1;i<len;i++) {
            String word1 = words[i-1];
            String word2 = words[i];
            
            int minLen = Math.min(word1.length(),word2.length());
            int j=0;
            boolean diff=false;
            for(j=0;j<minLen;j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2) {
                    if(map.get(c1).add(c2)) {
                        indegree[c2-'a']++;
                    }
                    diff=true;
                    break;
                }
            }

            if(!diff && word1.length() > word2.length()) return "";
        }

        Queue<Character> que = new LinkedList<>();
        for(char c='a';c<='z';c++) {
            if(indegree[c-'a'] == 0) 
                que.add(c);
        }

        StringBuilder str = new StringBuilder();
        while(!que.isEmpty()) {
            char c = que.poll();
            str.append(c);

            for(char nc : map.get(c)) {
                indegree[nc-'a']--;

                if(indegree[nc-'a'] == 0) {
                    que.add(nc);
                }
            }
        }
        String ans = str.toString();
        if(ans.length() == numChars) return ans;
        return "";
    }
}
