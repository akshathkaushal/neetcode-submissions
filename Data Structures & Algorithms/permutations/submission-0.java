class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        Arrays.fill(visit, false);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(nums,visit,temp,res);
        return res;
    }
    private void helper(int[] nums, boolean[] visit, 
    List<Integer> temp, List<List<Integer>> res) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!visit[i]) {
                visit[i]=true;
                temp.add(nums[i]);
                helper(nums,visit,temp,res);
                temp.removeLast();
                visit[i]=false;
            }
        }
    }
}
