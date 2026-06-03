import java.util.*;

class Solution {

    public int earliestFinishTime(
            int[] landStartTime,
            int[] landDuration,
            int[] waterStartTime,
            int[] waterDuration) {

        long ans = Long.MAX_VALUE;

        int n = landStartTime.length;
        int m = waterStartTime.length;

        // ---------------------------
        // Land -> Water
        // ---------------------------

        int[][] water = new int[m][2];
        for (int i = 0; i < m; i++) {
            water[i][0] = waterStartTime[i];
            water[i][1] = waterDuration[i];
        }

        Arrays.sort(water, (a, b) -> Integer.compare(a[0], b[0]));

        int[] wStart = new int[m];
        long[] prefMinDur = new long[m];
        long[] sufMinStartPlusDur = new long[m];

        for (int i = 0; i < m; i++) {
            wStart[i] = water[i][0];
        }

        prefMinDur[0] = water[0][1];
        for (int i = 1; i < m; i++) {
            prefMinDur[i] = Math.min(prefMinDur[i - 1], water[i][1]);
        }

        sufMinStartPlusDur[m - 1] =
                (long) water[m - 1][0] + water[m - 1][1];

        for (int i = m - 2; i >= 0; i--) {
            long cur = (long) water[i][0] + water[i][1];
            sufMinStartPlusDur[i] =
                    Math.min(cur, sufMinStartPlusDur[i + 1]);
        }

        for (int i = 0; i < n; i++) {

            long endLand =
                    (long) landStartTime[i] + landDuration[i];

            int idx = upperBound(wStart, endLand);

            if (idx >= 0) {
                ans = Math.min(ans,
                        endLand + prefMinDur[idx]);
            }

            if (idx + 1 < m) {
                ans = Math.min(ans,
                        sufMinStartPlusDur[idx + 1]);
            }
        }

        // ---------------------------
        // Water -> Land
        // ---------------------------

        int[][] land = new int[n][2];
        for (int i = 0; i < n; i++) {
            land[i][0] = landStartTime[i];
            land[i][1] = landDuration[i];
        }

        Arrays.sort(land, (a, b) -> Integer.compare(a[0], b[0]));

        int[] lStart = new int[n];
        long[] prefMinLandDur = new long[n];
        long[] sufMinStartPlusLandDur = new long[n];

        for (int i = 0; i < n; i++) {
            lStart[i] = land[i][0];
        }

        prefMinLandDur[0] = land[0][1];
        for (int i = 1; i < n; i++) {
            prefMinLandDur[i] =
                    Math.min(prefMinLandDur[i - 1], land[i][1]);
        }

        sufMinStartPlusLandDur[n - 1] =
                (long) land[n - 1][0] + land[n - 1][1];

        for (int i = n - 2; i >= 0; i--) {
            long cur = (long) land[i][0] + land[i][1];
            sufMinStartPlusLandDur[i] =
                    Math.min(cur, sufMinStartPlusLandDur[i + 1]);
        }

        for (int j = 0; j < m; j++) {

            long endWater =
                    (long) waterStartTime[j] + waterDuration[j];

            int idx = upperBound(lStart, endWater);

            if (idx >= 0) {
                ans = Math.min(ans,
                        endWater + prefMinLandDur[idx]);
            }

            if (idx + 1 < n) {
                ans = Math.min(ans,
                        sufMinStartPlusLandDur[idx + 1]);
            }
        }

        return (int) ans;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return l - 1;
    }
}