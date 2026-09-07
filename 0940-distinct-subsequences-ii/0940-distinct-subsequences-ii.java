class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1000000007;

        long[] last = new long[26];

        long total = 0;

        for (char ch : s.toCharArray()) {

            int index = ch - 'a';

            // Number of new subsequences ending with ch
            long newCount = total + 1;

            // Remove duplicate subsequences
            total = (total + newCount - last[index] + MOD) % MOD;

            // Update latest contribution of this character
            last[index] = newCount % MOD;
        }

        return (int) total;
    }
}