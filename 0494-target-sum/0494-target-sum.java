class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int ans = 0;
        if ((sum + target) % 2 != 0) {
            return 0; 
        }
        if((sum + target) < 0){
            return 0;
        }

        int s1 = (sum + target) / 2;
        ans = perfectSum(nums, s1);
        return ans;
    }

    public int perfectSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[target];
    }
}