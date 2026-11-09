class Solution {
    public boolean isHappy(int n) {
        int cur;
        Set<Integer> set = new HashSet<>();

        while(true) {
            if(n == 1) return true;
            cur = n;
            int sum=0;
            while(cur>0) {
                int dig = cur%10;
                sum += (dig*dig);
                cur/=10;
            }
            if(set.contains(sum)) return false;
            else set.add(sum);
            n=sum;
        }
    }
}
