class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        final int MOD = 1_000_000_007;

        long[] dp = new long[n + 1];     // dp[i] = ways to partition nums[0..i-1]
        long[] pref = new long[n + 1];   // prefix sums of dp

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> maxDQ = new ArrayDeque<>();
        Deque<Integer> minDQ = new ArrayDeque<>();

        int left = 0; // window [left, right]

        for (int right = 0; right < n; right++) {
            int x = nums[right];

            // maintain decreasing deque for max
            while (!maxDQ.isEmpty() && nums[maxDQ.peekLast()] <= x) {
                maxDQ.pollLast();
            }
            maxDQ.offerLast(right);

            // maintain increasing deque for min
            while (!minDQ.isEmpty() && nums[minDQ.peekLast()] >= x) {
                minDQ.pollLast();
            }
            minDQ.offerLast(right);

            // shrink window until condition max - min <= k holds
            while (!maxDQ.isEmpty() && !minDQ.isEmpty() &&
                   (long)nums[maxDQ.peekFirst()] - (long)nums[minDQ.peekFirst()] > k) {
                if (maxDQ.peekFirst() == left) maxDQ.pollFirst();
                if (minDQ.peekFirst() == left) minDQ.pollFirst();
                left++;
            }

            int i = right + 1; // prefix length index for dp

            // valid start indices s are in [left, right] → dp indices s
            long total = pref[i - 1];
            long subtract = (left > 0) ? pref[left - 1] : 0;
            long ways = (total - subtract) % MOD;
            if (ways < 0) ways += MOD;

            dp[i] = ways;
            pref[i] = (pref[i - 1] + dp[i]) % MOD;
        }

        return (int) dp[n];
    }
}