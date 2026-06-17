class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        long LIMIT = (long)1e15 + 1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                len[i + 1] = Math.min(LIMIT, len[i] + 1);
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = Math.min(LIMIT, len[i] * 2);
            } else { // %
                len[i + 1] = len[i];
            }
        }

        if (k >= len[n]) return '.';

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            long before = len[i];
            long after = len[i + 1];

            if (Character.isLowerCase(ch)) {

                if (k == after - 1) {
                    return ch;
                }

            } else if (ch == '*') {

                // k unchanged

            } else if (ch == '#') {

                k %= before;

            } else { // %

                k = before - 1 - k;
            }
        }

        return '.';
    }
}