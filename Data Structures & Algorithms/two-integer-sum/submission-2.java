class Solution {
    public int[] twoSum(int[] nums, int target) {
        // to store the value:position
        HashMap<Integer,Integer> _map = new HashMap<>();
        int res[] = new int[2];
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(_map.containsKey(target-nums[i])) {
                res[0] = _map.get(target-nums[i]); 
                res[1] = i;
                break;
            }
            _map.put(nums[i],i);
        }

        return res;
    }
}
