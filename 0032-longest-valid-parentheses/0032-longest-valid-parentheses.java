class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Base for valid substring calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i); // Push index of '('
            } else {
                stack.pop(); // Pop matching '(' index
                if (stack.isEmpty()) {
                    stack.push(i); // New base index
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }

        return maxLen;
    }
}