class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        
        // Base cases for small arrays
        if (n < 3) {
            return n;
        }
        
        // Find the number of bits required to represent n
        int bitLength = 32 - Integer.numberOfLeadingZeros(n);
        
        // Total possible unique XOR values is 2^(bitLength)
        return 1 << bitLength;
    }
}