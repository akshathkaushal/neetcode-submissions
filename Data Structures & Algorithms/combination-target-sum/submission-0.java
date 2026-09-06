class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(nums,0,target,temp,res);
        return res;
    }
    private void helper(int[] nums, int idx, int target, 
    List<Integer> temp,
    List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target<0 ||idx==nums.length) {
            return;
        }

        helper(nums,idx+1,target,temp,res);
        temp.add(nums[idx]);
        helper(nums,idx,target-nums[idx],temp,res);
        temp.removeLast();
    }
}
