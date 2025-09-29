class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] memo= new int[n][n];
        return dfs(values,0,n-1,memo);
    }
    public static int dfs(int[] v,int i,int j,int[][] memo){
        if(j-i < 2){
            return 0;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            int cost = dfs(v,i,k,memo) + dfs(v,k,j,memo) + v[i]*v[j]*v[k];
            ans = Math.min(ans,cost);
        }
        memo[i][j]=ans;
        return memo[i][j];
    }
}