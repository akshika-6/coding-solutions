class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;

        int m = heights.length, n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Directions: up, down, left, right
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // DFS function
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0, directions);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1, directions);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, j, directions);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, j, directions);
        }

        // Collect intersection of reachable cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] visited, int prevHeight, int r, int c, int[][] directions) {
        int m = heights.length, n = heights[0].length;

        // Base conditions
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (visited[r][c]) return;
        if (heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        for (int[] dir : directions) {
            dfs(heights, visited, heights[r][c], r + dir[0], c + dir[1], directions);
        }
    }
}