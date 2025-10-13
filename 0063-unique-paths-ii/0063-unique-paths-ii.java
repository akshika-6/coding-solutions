class Solution {
    public int uniquePathsWithObstacles(int[][] a) {
        int m=a.length;
        int n=a[0].length;
        int[][] d=new int[m][n];
        d[0][0]=1;
        for(int j=1;j<n;j++){
            if(a[0][j] == 0 && d[0][j-1] == 1){
                d[0][j]=1;
            } else{
                d[0][j]=0;
            }
        }
        for(int i=1;i<m;i++){
            if(a[i][0] == 0 && d[i-1][0] == 1){
                d[i][0]=1;
            } else{
                d[i][0]=0;
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(a[i][j] == 1){
                    d[i][j]=0;
                }else{
                    d[i][j]=d[i-1][j]+d[i][j-1];
                }
            }
        }
        return d[m-1][n-1];
    }
}