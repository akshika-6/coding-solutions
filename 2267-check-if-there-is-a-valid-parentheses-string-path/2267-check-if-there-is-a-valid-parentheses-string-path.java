class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Total number of characters must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        int maxBalance = m + n;

        boolean[][][] dp = new boolean[m][n][maxBalance];

        // Starting cell
        int balance = grid[0][0] == '(' ? 1 : -1;

        if (balance < 0) {
            return false;
        }

        dp[0][0][balance] = true;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int value = grid[i][j] == '(' ? 1 : -1;

                for (int b = 0; b < maxBalance; b++) {

                    // Come from top
                    if (i > 0 && dp[i - 1][j][b]) {

                        int newBalance = b + value;

                        if (newBalance >= 0 &&
                            newBalance < maxBalance) {

                            dp[i][j][newBalance] = true;
                        }
                    }

                    // Come from left
                    if (j > 0 && dp[i][j - 1][b]) {

                        int newBalance = b + value;

                        if (newBalance >= 0 &&
                            newBalance < maxBalance) {

                            dp[i][j][newBalance] = true;
                        }
                    }
                }
            }
        }

        // Valid parentheses string must end with balance 0
        return dp[m - 1][n - 1][0];
    }
}