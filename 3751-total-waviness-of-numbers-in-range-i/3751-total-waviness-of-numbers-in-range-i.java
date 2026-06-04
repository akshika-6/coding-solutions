class Solution {
    
    private int waviness(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) return 0;

        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char left = s.charAt(i - 1);
            char curr = s.charAt(i);
            char right = s.charAt(i + 1);

            if ((curr > left && curr > right) ||
                (curr < left && curr < right)) {
                count++;
            }
        }

        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int num = num1; num <= num2; num++) {
            ans += waviness(num);
        }

        return ans;
    }
}