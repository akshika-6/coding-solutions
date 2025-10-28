class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int s=sum+target;
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) {
            return 0; 
        }
        int s1=s/2;
        int ans=perfectSum(nums,s1);
        return ans;
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int[] dp=new int[target+1];
        dp[0]=1;
        //dp[arr[0]]=1;
        for(int i=0;i<nums.length;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}