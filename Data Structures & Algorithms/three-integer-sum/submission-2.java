class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            // 2 pointer approach
            int j=i+1, k=nums.length-1;
            while(j<k) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    res.add(List.of(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } else if(nums[i] + nums[j] + nums[k] < 0) j++;
                else k--;
            }
        }
        return new ArrayList<>(res);
    }
}
