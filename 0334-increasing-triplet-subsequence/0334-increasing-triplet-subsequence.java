class Solution {
    public boolean increasingTriplet(int[] nums) {
       int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                // Update smallest so far
                first = num;
            } else if (num <= second) {
                // Update second smallest
                second = num;
            } else {
                // Found third number > first and > second
                return true;
            }
        }
        
        return false;
    }
}