class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        List<Integer>[] freq = new List[nums.length+1];
        for(int i=0;i<freq.length;i++) freq[i] = new ArrayList<>();

        freqMap.forEach((num,f) -> {
            freq[f].add(num);
        });

        int[] res = new int [k];
        int idx=0;
        for(int i=freq.length-1;i>=0 && idx<k;i--) {
            for(int num:freq[i]) {
                res[idx++] = num;
                if(idx == k) return res;
            }
        }

        return res;
    }
}
