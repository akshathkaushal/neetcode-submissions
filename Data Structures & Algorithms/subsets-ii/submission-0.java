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
        res.add(new ArrayList<>(temp));

        for(int i=idx;i<nums.length;i++) {
            if(i>idx && nums[i] == nums[i-1]) continue;

            temp.add(nums[i]);
            helper(nums,i+1,temp,res);
            temp.removeLast();
        }
    }
}
