class Solution {
    public int orangesRotting(int[][] grid) {
        
if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        // Queue will store {row, col, time}
        Queue<int[]> q = new LinkedList<>();

        int fresh = 0; // count of fresh oranges

        // Step 1: Push all initially rotten oranges to queue & count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0}); // rotten orange with time = 0
                } else if (grid[i][j] == 1) {
                    fresh++; // fresh orange count
                }
            }
        }

        // If no fresh oranges, return 0
        if (fresh == 0) return 0;

        int time = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int t = curr[2];
            time = Math.max(time, t);

            // explore 4 directions
            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                // check bounds and if fresh orange is found
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2; // make rotten
                    fresh--; // reduce fresh count
                    q.offer(new int[]{nr, nc, t + 1}); // push with time + 1
                }
            }
        }

        // Step 3: If fresh still remains -> impossible
        return fresh == 0 ? time : -1;
    }
}



















        // int n = grid.length;
        // int m = grid[0].length;
        // Queue<int[]> q = new LinkedList<>();
        // int fresh = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(grid == 2){
        //             q.add(new int[]{i,j});
        //         } else if(grid[i][j] == 1){
        //             fresh++;
        //         }
        //     }
        // }
        // if(fresh == 0) return 0;
        // int min = -1;
        // int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        // while(!q.isEmpty()){
        //     int size = q.size();
        //     min++;
        //     for(int i=0;i<size;i++){
        //         int[] cell = q.poll();
        //         for(int[] d : dirs){
        //             int r = cell[0] + d[1];
        //             int c = cell[1] + d[1];
        //         }
        //     }
        // }
















//         int n = grid.length, m = grid[0].length;
//         Queue<int[]> q = new LinkedList<>();
//         int fresh = 0;

//         // Step 1: Add all rotten oranges to queue & count fresh
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 2) {
//                     q.add(new int[]{i, j});
//                 } else if (grid[i][j] == 1) {
//                     fresh++;
//                 }
//             }
//         }

//         // If no fresh oranges, return 0
//         if (fresh == 0) return 0;

//         int minutes = -1;
//         int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

//         // Step 2: BFS
//         while (!q.isEmpty()) {
//             int size = q.size();
//             minutes++;
//             for (int i = 0; i < size; i++) {
//                 int[] cell = q.poll();
//                 for (int[] d : dirs) {
//                     int r = cell[0] + d[0];
//                     int c = cell[1] + d[1];
//                     if (r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
//                         grid[r][c] = 2;
//                         fresh--;
//                         q.add(new int[]{r, c});
//                     }
//                 }
//             }
//         }

//         return fresh == 0 ? minutes : -1;
//     }
// }