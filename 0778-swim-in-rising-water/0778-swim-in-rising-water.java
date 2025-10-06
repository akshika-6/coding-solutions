class Solution {
    public int swimInWater(int[][] grid) {
       int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        // min-heap: [timeToReach, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int t = curr[0], r = curr[1], c = curr[2];
            if (r == n - 1 && c == n - 1) return t;  // reached destination
            if (visited[r][c]) continue;
            visited[r][c] = true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    int nextTime = Math.max(t, grid[nr][nc]);
                    pq.offer(new int[]{nextTime, nr, nc});
                }
            }
        }
        return -1; 
    }
}