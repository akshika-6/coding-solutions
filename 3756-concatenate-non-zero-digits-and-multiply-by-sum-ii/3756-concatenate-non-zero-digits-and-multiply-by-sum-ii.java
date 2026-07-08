class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        // cnt[i] = number of non-zero digits before index i
        int[] cnt = new int[n + 1];
        int nonZero = 0;

        for (int i = 0; i < n; i++) {
            cnt[i + 1] = cnt[i];
            if (s.charAt(i) != '0') {
                cnt[i + 1]++;
                nonZero++;
            }
        }

        // Precompute powers of 10
        long[] pow10 = new long[nonZero + 1];
        pow10[0] = 1;
        for (int i = 1; i <= nonZero; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        // Prefix number and prefix digit sum of non-zero digits
        long[] prefixNum = new long[nonZero + 1];
        long[] prefixSum = new long[nonZero + 1];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch != '0') {
                int d = ch - '0';
                prefixNum[idx + 1] = (prefixNum[idx] * 10 + d) % MOD;
                prefixSum[idx + 1] = prefixSum[idx] + d;
                idx++;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = cnt[l];
            int right = cnt[r + 1];

            if (left == right) {
                ans[i] = 0;
                continue;
            }

            int len = right - left;

            long x = (prefixNum[right]
                    - (prefixNum[left] * pow10[len]) % MOD
                    + MOD) % MOD;

            long digitSum = prefixSum[right] - prefixSum[left];

            ans[i] = (int) ((x * digitSum) % MOD);
        }

        return ans;
    }
}