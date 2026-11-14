class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        int i=0;
        while(i<n-2) {
            if(i>0 && nums[i] == nums[i-1]) {
                i++;
                continue;
            }
            int l=i+1, r=n-1;

            while(l<r) {
                int sum = nums[i]+nums[l]+nums[r];
                if(sum > 0) {
                    r--;
                } else if(sum < 0) {
                    l++;
                } else {
                    List<Integer> cur = List.of(nums[i],nums[l],nums[r]);
                    result.add(cur);
                    l++;
                    r--;
                    while(l<r && nums[l] == nums[l-1]) l++;
                    while(l<r && nums[r] == nums[r+1]) r--;
                }
            }
            i++;
        }
        return result;
    }
}
