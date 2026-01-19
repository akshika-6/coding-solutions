class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        // Prefix sum matrix
        int[][] prefix = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                             + prefix[i - 1][j]
                             + prefix[i][j - 1]
                             - prefix[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(prefix, mid, threshold)) {
                ans = mid;
                low = mid + 1;   // try bigger square
            } else {
                high = mid - 1;  // try smaller square
            }
        }

        return ans;
    }

    private boolean isValid(int[][] prefix, int k, int threshold) {
        int m = prefix.length - 1;
        int n = prefix[0].length - 1;

        for (int i = 0; i + k <= m; i++) {
            for (int j = 0; j + k <= n; j++) {
                int sum = prefix[i + k][j + k]
                        - prefix[i][j + k]
                        - prefix[i + k][j]
                        + prefix[i][j];

                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}
