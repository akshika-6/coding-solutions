class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                // already seen → duplicate
                result.add(num);
            }
        }

        // convert to int[]
        return new int[]{result.get(0), result.get(1)};
        
    }
}