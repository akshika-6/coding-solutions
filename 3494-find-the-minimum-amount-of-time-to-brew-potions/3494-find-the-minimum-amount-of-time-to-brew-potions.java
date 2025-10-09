class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        if (n == 0 || m == 0) return 0;

        long[] start = new long[m]; // start[j] = start time of potion j
        start[0] = 0;

        for (int j = 1; j < m; j++) {
            // compute prefix sums for column j-1 and column j
            long[] prefPrev = new long[n];
            long[] prefCurr = new long[n];
            prefPrev[0] = 1L * skill[0] * mana[j - 1];
            prefCurr[0] = 1L * skill[0] * mana[j];
            for (int i = 1; i < n; i++) {
                prefPrev[i] = prefPrev[i - 1] + 1L * skill[i] * mana[j - 1];
                prefCurr[i] = prefCurr[i - 1] + 1L * skill[i] * mana[j];
            }

            long best = Long.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                long leftSum = prefPrev[i];                        // sum_{0..i} previous potion
                long rightSumBefore = (i - 1 >= 0) ? prefCurr[i - 1] : 0; // sum_{0..i-1} current potion
                long candidate = start[j - 1] + leftSum - rightSumBefore;
                if (candidate > best) best = candidate;
            }
            start[j] = best;
        }

        // total time = start of last potion + total time for last potion
        long totalLast = 0;
        for (int i = 0; i < n; i++) totalLast += 1L * skill[i] * mana[m - 1];

        return start[m - 1] + totalLast;
    }
}