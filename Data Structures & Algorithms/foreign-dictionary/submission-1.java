class Solution {
    public String foreignDictionary(String[] words) {
        int totalChars = 0;
        int[] indegree = new int[26];
        for(int i=0;i<26;i++) indegree[i] = -1;
        for(String word : words) {
            for(char c : word.toCharArray()) {
                indegree[c-'a'] = 0;
            }
        }
        List<Set<Character>> adj = new ArrayList<>();
        for(int i=0;i<26;i++) {
            adj.add(new HashSet<>());
        }
        // populate the adjacency list
        // and update indegree
        if(!compareWords(words,adj,indegree)) return "";
        
        Queue<Character> que = new ArrayDeque<>();
        for(char c='a';c<='z';c++) {
            // System.out.println(indegree[c-'a']);
            if(indegree[c-'a'] != -1) totalChars++;
            if(indegree[c-'a'] == 0) {
                que.add(c);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!que.isEmpty()) {
            char c1 = que.poll();
            str.append(c1);

            for(char c : adj.get(c1-'a')) {
                indegree[c-'a']--;

                if(indegree[c-'a'] == 0) {
                    que.add(c);
                }
            }            
        }
        if(str.length() != totalChars) return "";

        return str.toString();
    }

    private boolean compareWords(String[] words, List<Set<Character>> adj, int[] indegree) {
        int len = words.length;

        for(int j = 0; j < len - 1; j++) {
            String word1 = words[j];
            String word2 = words[j+1];

            int minLen = Math.min(word1.length(), word2.length());
            boolean foundDifference = false;

            for(int p = 0; p < minLen; p++) {
                char c1 = word1.charAt(p);
                char c2 = word2.charAt(p);

                if(c1 != c2) {
                    if(adj.get(c1-'a').add(c2)) {
                        indegree[c2-'a']++;
                    }

                    foundDifference = true;
                    break;
                }
            }

            if(!foundDifference && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
