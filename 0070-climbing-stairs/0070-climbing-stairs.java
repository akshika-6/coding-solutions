class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        int x=helper(n,arr);
        return x;
    }
    public static int helper(int n,int[] arr){
        if(n <= 2){
            return n;
        }
        if(arr[n] != -1){
            return arr[n];
        }
        arr[n]=helper(n-1,arr)+helper(n-2,arr);
        return arr[n];
    }
}






