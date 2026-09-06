class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,0,temp,res);
        return res;
    }
    private void helper(int[] nums, int idx, 
    List<Integer> temp, List<List<Integer>> res) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[idx]);
        helper(nums,idx+1,temp,res);
        temp.removeLast();

        while(idx+1<nums.length && nums[idx] == nums[idx+1]) idx++;
        helper(nums,idx+1,temp,res);
    }
}
