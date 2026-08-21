class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i : nums) numSet.add(i);

        int res=0;
        for(int n : nums) {
            if(!numSet.contains(n-1)) {
                int maxLen = 1;
                while(numSet.contains(n+maxLen)) maxLen++;
                res = Math.max(res,maxLen);
            }
        }
        return res;
    }
}
