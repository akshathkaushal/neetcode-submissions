class Solution {
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int res = Integer.MIN_VALUE;

        while(i<j) {
            int newArea = (j-i)*Math.min(heights[i],heights[j]);
            res = Math.max(res,newArea);

            if(heights[i]<heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return res;
    }
}
