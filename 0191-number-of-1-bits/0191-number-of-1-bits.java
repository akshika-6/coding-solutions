class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // Iterate until n becomes zero
        while (n != 0) {
            // Perform n & (n - 1) to remove the rightmost 1-bit
            n = n & (n - 1);
            // Increment the counter for each 1-bit removed
            count++;
        }
        return count;
    }
}