class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,0,res,temp);
        return res;
    }
    private void helper(int[] nums, int idx, List<List<Integer>> res, List<Integer> temp) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        helper(nums,idx+1,res,temp);
        temp.add(nums[idx]);
        helper(nums,idx+1,res,temp);
        temp.removeLast();
    }
}
