import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int[] pos = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = arr[i][0];
            pos[arr[i][1]] = i;
        }

        // component ids
        int[] comp = new int[n];
        int cid = 0;
        comp[0] = 0;
        for (int i = 1; i < n; i++) {
            if (values[i] - values[i - 1] > maxDiff) cid++;
            comp[i] = cid;
        }

        // next reachable
        int[] next = new int[n];
        int r = 0;
        for (int l = 0; l < n; l++) {
            while (r + 1 < n && values[r + 1] - values[l] <= maxDiff)
                r++;
            next[l] = r;
            if (r == l) r++;
        }

        int LOG = 17;
        while ((1 << LOG) <= n) LOG++;

        int[][] up = new int[LOG][n];
        up[0] = next.clone();

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int qi = 0; qi < queries.length; qi++) {

            int u = pos[queries[qi][0]];
            int v = pos[queries[qi][1]];

            if (u == v) {
                ans[qi] = 0;
                continue;
            }

            if (u > v) {
                int t = u;
                u = v;
                v = t;
            }

            if (comp[u] != comp[v]) {
                ans[qi] = -1;
                continue;
            }

            int cur = u;
            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[k][cur] < v) {
                    cur = up[k][cur];
                    steps += 1 << k;
                }
            }

            ans[qi] = steps + 1;
        }

        return ans;
    }
}