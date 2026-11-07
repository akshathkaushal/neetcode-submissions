class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] visited = new boolean[s.length()];
        return helper(s,0,wordDict,visited);
    }
    private boolean helper(String s, int idx, List<String> wordDict, boolean[] visited) {
        if(idx == s.length()) return true;

        // already visited the index, but were not able to break
        if(visited[idx]) return false;

        for(String word : wordDict) {
            int len = word.length();
            if(idx+len <= s.length() && s.substring(idx,idx+len).equals(word)) {
                if(helper(s,idx+len,wordDict,visited)) return true;
            }
        }

        visited[idx] = true;
        return false;
    }
}
