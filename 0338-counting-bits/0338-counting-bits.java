class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        int pow = 1; // Current power of two
        int x = 1; // Index at the current power level

        for (int i = 1; i <= n; i++) {
            if (i == pow) {
                pow *= 2; // Move to the next power of two
                x = i;
            }
            res[i] = res[i - x] + 1; // Use the result from a smaller index plus one
        }
        return res;
    }
}