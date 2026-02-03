class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        // 1️⃣ strictly increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0) return false;

        // 2️⃣ strictly decreasing
        int decStart = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == decStart) return false;

        // 3️⃣ strictly increasing again (must happen at least once)
        boolean thirdIncrease = false;
        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
            thirdIncrease = true;
        }

        return thirdIncrease && i == n - 1;
    }
}