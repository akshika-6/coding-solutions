class Solution {
    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int x : nums) {
            if (seen.contains(x)) return x;
            seen.add(x);
        }
        // Problem guarantees an answer exists
        return -1;
    }
}