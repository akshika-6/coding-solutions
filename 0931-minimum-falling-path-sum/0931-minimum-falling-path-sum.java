class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] d = new int[m][n];
        for (int j = 0; j < n; j++) {
            d[0][j] = matrix[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up=matrix[i][j]+d[i-1][j];
                int left=matrix[i][j];
                int right=matrix[i][j];
                if(j-1 >= 0){
                    left +=  d[i-1][j-1];
                } else {
                    left += (int)1e9;
                }
                if(j < n-1){
                    right +=  d[i-1][j+1];
                } else {
                    right += (int)1e9;
                }
                d[i][j]=Math.min(right,Math.min(up,left));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, d[m - 1][j]);
        }
        return ans;
    }
}