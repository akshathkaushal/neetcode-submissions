class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;

        while(i<j) {
            int val = numbers[i]+numbers[j];

            if(val == target) break;
            else if(val<target) i++;
            else j--;
        }

        return new int[]{i+1,j+1};
    }
}
