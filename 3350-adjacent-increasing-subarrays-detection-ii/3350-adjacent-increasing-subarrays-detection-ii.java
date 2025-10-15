class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] left = new int[n];  // length of increasing sequence ending at i
        int[] right = new int[n]; // length of increasing sequence starting at i

        // compute left[]
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i-1)) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        // compute right[]
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i+1)) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        // find maximum k such that two adjacent increasing subarrays of length k exist
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int k = Math.min(left[i], right[i + 1]);
            ans = Math.max(ans, k);
        }

        return ans;
    }
}