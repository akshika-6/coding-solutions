class Solution {
    public int numberOfSpecialChars(String word) {

        int[] lower = new int[26];
        int[] upper = new int[26];

        // initialize
        for (int i = 0; i < 26; i++) {
            lower[i] = -1;
            upper[i] = Integer.MAX_VALUE;
        }

        // traverse string
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (Character.isLowerCase(ch)) {

                lower[ch - 'a'] = i;

            } else {

                upper[ch - 'A'] =
                    Math.min(upper[ch - 'A'], i);
            }
        }

        int count = 0;

        // check condition
        for (int i = 0; i < 26; i++) {

            if (lower[i] != -1 &&
                upper[i] != Integer.MAX_VALUE &&
                lower[i] < upper[i]) {

                count++;
            }
        }

        return count;
    }
}