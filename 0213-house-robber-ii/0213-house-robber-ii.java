class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // only one house

        // Case 1: rob from house 0 to n-2
        int case1 = robLinear(nums, 0, n - 2);

        // Case 2: rob from house 1 to n-1
        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    // Helper function for the linear House Robber problem
    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0; // max amount till i-1
        int prev2 = 0; // max amount till i-2

        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }

        return prev1;
    }
}