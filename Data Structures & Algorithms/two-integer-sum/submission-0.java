class Solution {
    public int[] twoSum(int[] nums, int target) {
        // to store the value:position
        HashMap<Integer,Integer> _map = new HashMap<>();

        int n = nums.length;
        for(int i=0;i<n;i++) {
            int otherHalf = target-nums[i];
            if(_map.containsKey(otherHalf)) {
                int idx = _map.get(otherHalf);
                int sm = Math.min(i,idx);
                int mx = Math.max(i,idx);
                return new int[]{sm,mx};
            } else {
                _map.put(nums[i],i);
            }
        }

        return new int[2];
    }
}
