class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // Use large value as "infinity" placeholder
        int INF = 1000000000;

        // Two smallest numbers with remainder 1
        int min1_1 = INF, min2_1 = INF;
        // Two smallest numbers with remainder 2
        int min1_2 = INF, min2_2 = INF;

        for (int num : nums) {
            sum += num;
            int r = num % 3;

            if (r == 1) {
                // update two smallest for remainder 1
                if (num < min1_1) {
                    min2_1 = min1_1;
                    min1_1 = num;
                } else if (num < min2_1) {
                    min2_1 = num;
                }
            } else if (r == 2) {
                // update two smallest for remainder 2
                if (num < min1_2) {
                    min2_2 = min1_2;
                    min1_2 = num;
                } else if (num < min2_2) {
                    min2_2 = num;
                }
            }
        }

        int rSum = sum % 3;
        if (rSum == 0) return sum;

        int ans = 0;

        if (rSum == 1) {
            int option1 = (min1_1 == INF) ? -1 : sum - min1_1;
            int option2 = (min1_2 == INF || min2_2 == INF) ? -1 : sum - (min1_2 + min2_2);
            ans = Math.max(option1, option2);
        } else { // rSum == 2
            int option1 = (min1_2 == INF) ? -1 : sum - min1_2;
            int option2 = (min1_1 == INF || min2_1 == INF) ? -1 : sum - (min1_1 + min2_1);
            ans = Math.max(option1, option2);
        }

        // If no valid way found, return 0
        return ans < 0 ? 0 : ans;
    }
}