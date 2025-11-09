class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
       return solveUtil(n,stones);
    }
    static boolean solveUtil(int n, int[] stones) {
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        dp.get(stones[0]).add(0); 

        for (int i = 0; i < n; i++) {
            int position = stones[i];
            for (int jump : dp.get(position)) {
                for (int step = jump - 1; step <= jump + 1; step++) {
                    if (step > 0) {
                        int nextPos = position + step;
                        if (nextPos == stones[n - 1]) return true; 
                        if (dp.containsKey(nextPos)) {
                            dp.get(nextPos).add(step);
                        }
                    }
                }
            }
        }

        return !dp.get(stones[n - 1]).isEmpty();
    }
}