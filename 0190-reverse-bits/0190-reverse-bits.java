class Solution {
    public int reverseBits(int n) {
        n = ((n >>> 1) & 0x55555555) | ((n & 0x55555555) << 1);

        // Swap 2-bit groups
        n = ((n >>> 2) & 0x33333333) | ((n & 0x33333333) << 2);

        // Swap 4-bit groups (nibbles)
        n = ((n >>> 4) & 0x0F0F0F0F) | ((n & 0x0F0F0F0F) << 4);

        // Swap 8-bit groups (bytes)
        n = ((n >>> 8) & 0x00FF00FF) | ((n & 0x00FF00FF) << 8);

        // Swap 16-bit halves
        n = ((n >>> 16) & 0x0000FFFF) | ((n & 0x0000FFFF) << 16);

        return n;
    }
}