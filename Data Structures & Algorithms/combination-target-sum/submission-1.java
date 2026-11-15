class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        helper(nums, 0, target, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int idx, int target, List<Integer> temp) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(idx == nums.length || target < 0) return;

        helper(nums,idx+1,target,temp);
        temp.add(nums[idx]);
        helper(nums,idx,target-nums[idx],temp);
        temp.remove(temp.size()-1);
    }
}
