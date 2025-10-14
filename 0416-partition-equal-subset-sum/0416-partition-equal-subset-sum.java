class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2 == 1) return false;
        int target=sum/2;
        return isSubsetSum(nums,target);
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int m=arr.length;
        boolean[][] dp=new boolean[m][sum+1];
        for(int i=0;i<m;i++){
            dp[i][0]=true;
        }
        if(arr[0] <= sum){
            dp[0][arr[0]]=true;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<=sum;j++){
                boolean notpick=dp[i-1][j];
                boolean pick=false;
                if(j-arr[i] >= 0){
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j]=pick || notpick;
            }
        }
        return dp[m-1][sum];
    }
}