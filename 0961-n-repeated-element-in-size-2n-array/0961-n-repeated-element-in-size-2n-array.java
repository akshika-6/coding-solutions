class Solution {
    public int repeatedNTimes(int[] nums) {
        int n2 = nums.length;
        // check adjacent and small-distance duplicates
        for (int i = 0; i < n2 - 1; ++i) {
            if (nums[i] == nums[i+1]) return nums[i];
            if (i + 2 < n2 && nums[i] == nums[i+2]) return nums[i];
            if (i + 3 < n2 && nums[i] == nums[i+3]) return nums[i];
        }
        // Fallback (shouldn't happen given constraints)
        return nums[0];
    }
}