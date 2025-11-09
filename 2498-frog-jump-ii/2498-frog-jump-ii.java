class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n == 2) return stones[1] - stones[0];

        int ans = 0;
        for (int i = 0; i + 2 < n; i++) {
            ans = Math.max(ans, stones[i + 2] - stones[i]);
        }
        return ans;
    }
}