class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Map<Integer,Boolean> map = new HashMap<>();
        for(int el:nums) {
            map.put(el,true);
        }

        int res=0;
        for(int el:nums) {
            if(map.containsKey(el-1)) continue;

            int len=0;
            while(map.containsKey(el)) {
                len++;
                el++;
                res = Math.max(res,len);
            }
        }

        return res;
    }
}
