class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l<=r) {
            int m = l+(r-l)/2;
            if(target == nums[m]) return m;

            // identify the sorted half
            if(nums[m] >= nums[l]) { // means left half is sorted
                if(target >= nums[l] && target <= nums[m]) {
                    r=m-1;
                } else {
                    l=m+1;
                }
            } else {
                if(target >= nums[m] && target <= nums[r]) {
                    l=m+1;
                } else {
                    r=m-1;
                }
            }
        }

        return -1;
    }
}
