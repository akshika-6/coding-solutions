class Cell {
        int row, col, effort;
        Cell(int r, int c, int e) {
            row = r;
            col = c;
            effort = e;
        }
    }
class Solution {
    public int minimumEffortPath(int[][] heights) {
       int rows = heights.length, cols = heights[0].length;
        
        int[][] dist = new int[rows][cols];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;
        
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        pq.add(new Cell(0, 0, 0));
        
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int r = cur.row, c = cur.col, eff = cur.effort;
            
            // If reached destination
            if (r == rows - 1 && c == cols - 1) return eff;
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    int newEffort = Math.max(eff, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Cell(nr, nc, newEffort));
                    }
                }
            }
        }
        
        return 0; // fallback (shouldn’t happen)
    }
}