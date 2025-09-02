class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Add all rotten oranges to queue & count fresh
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If no fresh oranges, return 0
        if (fresh == 0) return 0;

        int minutes = -1;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                for (int[] d : dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        fresh--;
                        q.add(new int[]{r, c});
                    }
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}