class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        // Case 1: rob houses 0 to n-2
        int case1 = robHelper(nums, 0, n - 2, memo1);
        // Case 2: rob houses 1 to n-1
        int case2 = robHelper(nums, 1, n - 1, memo2);

        return Math.max(case1, case2);
    }

    private int robHelper(int[] nums, int i, int n, int[] memo) {
        if (i > n) return 0;
        if (memo[i] != -1) return memo[i];

        // Option 1: Rob current house, skip next
        int robCurrent = nums[i] + robHelper(nums, i + 2, n, memo);
        // Option 2: Skip current house
        int skipCurrent = robHelper(nums, i + 1, n, memo);

        memo[i] = Math.max(robCurrent, skipCurrent);
        return memo[i];
    }
}