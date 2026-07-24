class Solution {

    public int uniqueXorTriplets(int[] nums) {
        int N = 2048; // 2^11

        long[] f = new long[N];

        for (int x : nums) {
            f[x] = 1; // only presence matters
        }

        fwht(f, false);

        for (int i = 0; i < N; i++) {
            f[i] = f[i] * f[i] * f[i];
        }

        fwht(f, true);

        int ans = 0;

        for (long cnt : f) {
            if (cnt > 0) ans++;
        }

        return ans;
    }

    private void fwht(long[] a, boolean inverse) {
        int n = a.length;

        for (int len = 1; len < n; len <<= 1) {
            for (int i = 0; i < n; i += (len << 1)) {
                for (int j = 0; j < len; j++) {
                    long u = a[i + j];
                    long v = a[i + j + len];

                    a[i + j] = u + v;
                    a[i + j + len] = u - v;
                }
            }
        }

        if (inverse) {
            for (int i = 0; i < n; i++) {
                a[i] /= n;
            }
        }
    }
}