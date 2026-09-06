class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,0,target,temp,res);
        return res;
    }
    private void helper(int[] arr, int idx, int target,
    List<Integer> temp,
    List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(target<0 || idx==arr.length) return;

        for(int i=idx;i<arr.length;i++) {
            if(i>idx && arr[i]==arr[i-1]) continue;

            if(arr[i]>target) break;
            
            temp.add(arr[i]);
            helper(arr,i+1,target-arr[i],temp,res);
            temp.removeLast();
        }
    }
}
