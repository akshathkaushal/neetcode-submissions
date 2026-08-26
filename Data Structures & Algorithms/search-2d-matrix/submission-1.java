class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m=matrix[0].length;
        for(int i=0;i<n;i++) {
            if(matrix[i][m-1] < target) continue;

            int l=0, r=m-1;
            while(l<=r) {
                int mid = l+(r-l)/2;
                if(matrix[i][mid] == target) return true;
                else if(matrix[i][mid] > target) r=mid-1;
                else l=mid+1;
            }
        }

        return false;
    }
}
