class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int n:nums) {
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }
        
        List<Integer>[] freqArr = new List[nums.length+1];
        for(int i=0;i<freqArr.length;i++) freqArr[i] = new ArrayList<>();
        freqMap.forEach((num,freq) -> {
            freqArr[freq].add(num);
        });

        int[] res = new int[k];

        int idx=0;
        for(int i=freqArr.length-1;i>=0;i--) {
            for(int n : freqArr[i]) {
                res[idx++] = n;
                if(idx == k) return res;
            }
        }

        return res;
    }
}
