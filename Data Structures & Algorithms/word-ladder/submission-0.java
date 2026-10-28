class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        // set.add(endWord);

        Queue<String> que = new ArrayDeque<>();
        que.offer(beginWord);

        int ans = 1;
        while(!que.isEmpty()) {
            int sz = que.size();

            while(sz > 0) {
                String cur = que.poll();
                if(cur.equals(endWord)) return ans;
                char[] curLetters = cur.toCharArray();

                int curLen = cur.length();
                for(int i=0;i<curLen;i++) {
                    char curChar = curLetters[i];

                    for(char j='a';j<='z';j++) {
                        if(curChar == j) continue;
                        curLetters[i] = j;
                        String nextWord = new String(curLetters);

                        if(set.contains(nextWord)) {
                            que.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                    curLetters[i] = curChar;
                }
                --sz;
            }
            ans++;
        }

        return 0;
    }
}
