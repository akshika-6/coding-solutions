class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // best[i] = shortest target-sum subarray
        // found in arr[0...i]
        int[] best = new int[n];

        // Large value means no valid subarray yet
        int INF = Integer.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int answer = INF;

        for (int right = 0; right < n; right++) {

            // Add current element
            sum += arr[right];

            // Shrink window if sum becomes too large
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Current window has target sum
            if (sum == target) {

                int len = right - left + 1;

                // Check if another valid subarray exists
                // completely before this one
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer,
                        len + best[left - 1]
                    );
                }

                // Store shortest valid subarray ending
                // at or before right
                if (right == 0) {
                    best[right] = len;
                } else {
                    best[right] = Math.min(best[right - 1], len);
                }
            } 
            else {
                // No valid subarray ending at right,
                // carry previous best
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return answer == INF ? -1 : answer;
    }
}