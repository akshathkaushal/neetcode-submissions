class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int n : nums) {
            freqMap.put(n,freqMap.getOrDefault(n,0)+1);
        }

        List<List<Integer>> freqArr = new ArrayList<>();
        for(int i=0;i<=nums.length;i++) {
            freqArr.add(new ArrayList<>());
        }

        freqMap.forEach((num,freq) -> {
            freqArr.get(freq).add(num);
        });

        int[] res = new int[k];
        int idx=0;
        for(int i=freqArr.size()-1;i>=0;i--) {
            for(int num:freqArr.get(i)) {
                res[idx++] = num;
                if(idx == k) return res;
            }
        }

        return res;
    }
}
