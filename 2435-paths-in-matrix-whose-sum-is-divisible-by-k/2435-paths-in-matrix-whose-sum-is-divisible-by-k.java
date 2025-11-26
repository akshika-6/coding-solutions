class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        final int MOD = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j][r] = number of paths to (i,j) with sum % k = r
        int[][][] dp = new int[m][n][k];

        int startRem = grid[0][0] % k;
        dp[0][0][startRem] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int val = grid[i][j];

                // from top
                if (i > 0) {
                    for (int r = 0; r < k; r++) {
                        if (dp[i-1][j][r] == 0) continue;
                        int newRem = (r + val) % k;
                        dp[i][j][newRem] += dp[i-1][j][r];
                        if (dp[i][j][newRem] >= MOD)
                            dp[i][j][newRem] -= MOD;
                    }
                }

                // from left
                if (j > 0) {
                    for (int r = 0; r < k; r++) {
                        if (dp[i][j-1][r] == 0) continue;
                        int newRem = (r + val) % k;
                        dp[i][j][newRem] += dp[i][j-1][r];
                        if (dp[i][j][newRem] >= MOD)
                            dp[i][j][newRem] -= MOD;
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}