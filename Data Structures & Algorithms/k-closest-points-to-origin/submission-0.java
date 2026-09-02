class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // store the distance, index
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));

        for(int i=0;i<points.length;i++) {
            int disSq = (int)Math.pow(points[i][0],2) + (int)Math.pow(points[i][1],2);
            que.add(new int[]{disSq,i});
        }

        int[][] res = new int[k][2];
        int j=k;
        while(j>0 && !que.isEmpty()) {
            int[] p = que.poll();
            res[k-j][0] = points[p[1]][0];
            res[k-j][1] = points[p[1]][1];
            j--;
        }
        return res;
    }
}
