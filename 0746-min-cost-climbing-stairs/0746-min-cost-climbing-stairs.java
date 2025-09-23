class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] m=new int[n];
        Arrays.fill(m,-1);
        return helper(0,n,m,cost);
    }
    public static int helper(int i,int n,int m[],int arr[]){
        if(i == n){
            return Math.min(m[n-1],m[n-2]);
        }
        if(i == 0 || i==1){
            m[i]=arr[i];
            return helper(i+1,n,m,arr);
        }
        m[i]=arr[i] + Math.min(m[i-1],m[i-2]);
        return helper(i+1,n,m,arr);
    }
}