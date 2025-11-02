class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       int[][] grid = new int[m][n];

        // 1 -> wall, 2 -> guard, 3 -> guarded
        for (int[] w : walls) grid[w[0]][w[1]] = 1;
        for (int[] g : guards) grid[g[0]][g[1]] = 2;

        // Directions: up, down, left, right
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int r = guard[0] + dir[0];
                int c = guard[1] + dir[1];

                while (r >= 0 && r < m && c >= 0 && c < n) {
                    if (grid[r][c] == 1 || grid[r][c] == 2) break; // stop at wall or another guard
                    if (grid[r][c] == 0) grid[r][c] = 3; // mark guarded
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count; 
    }
}