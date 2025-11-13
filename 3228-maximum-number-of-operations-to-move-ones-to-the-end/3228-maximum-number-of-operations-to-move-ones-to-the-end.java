class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int ones = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (c == '1') {
                ones++;
            } else {  // c == '0'
                // Boundary zero: last char OR next char is '1'
                if (i + 1 == n || s.charAt(i + 1) == '1') {
                    ans += ones;
                }
            }
        }
        return ans;
    }
}