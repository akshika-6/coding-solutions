import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] id = new int[m][n];

        for (int[] row : id) {
            Arrays.fill(row, -1);
        }

        // Find start and assign IDs to litter
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    id[i][j] = litterCount++;
                }
            }
        }

        int allMask = (1 << litterCount) - 1;

        if (litterCount == 0) {
            return 0;
        }

        // best[r][c][mask] = maximum energy reached
        int[][][] best = new int[m][n][1 << litterCount];

        for (int[][] a : best) {
            for (int[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        // r, c, mask, remainingEnergy, moves
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{sr, sc, 0, energy, 0});
        best[sr][sc][0] = energy;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            int r = cur[0];
            int c = cur[1];
            int mask = cur[2];
            int e = cur[3];
            int moves = cur[4];

            if (mask == allMask) {
                return moves;
            }

            // If energy is 0, we can continue only from R
            if (e == 0) {
                if (classroom[r].charAt(c) == 'R') {
                    e = energy;
                } else {
                    continue;
                }
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Boundary check
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Need energy to move
                if (e == 0) {
                    continue;
                }

                int newEnergy = e - 1;
                int newMask = mask;

                char cell = classroom[nr].charAt(nc);

                // Collect litter
                if (cell == 'L') {
                    newMask |= (1 << id[nr][nc]);
                }

                // Reset energy
                if (cell == 'R') {
                    newEnergy = energy;
                }

                // Already reached this state with more energy
                if (best[nr][nc][newMask] >= newEnergy) {
                    continue;
                }

                best[nr][nc][newMask] = newEnergy;

                q.offer(new int[]{
                    nr,
                    nc,
                    newMask,
                    newEnergy,
                    moves + 1
                });
            }
        }

        return -1;
    }
}