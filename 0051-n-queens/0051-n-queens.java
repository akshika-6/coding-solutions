class Solution {
    public List<List<String>> solveNQueens(int n) {
       List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n]; // queens[i] = column position of queen in row i
        placeQueens(0, n, queens, result);
        return result;
    }

    private void placeQueens(int row, int n, int[] queens, List<List<String>> result) {
        if (row == n) {
            result.add(buildBoard(queens, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, queens)) {
                queens[row] = col;
                placeQueens(row + 1, n, queens, result);
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            int qCol = queens[i];
            if (qCol == col || Math.abs(qCol - col) == Math.abs(i - row)) {
                return false; // Same column or diagonal
            }
        }
        return true;
    }

    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                sb.append(col == queens[row] ? "Q" : ".");
            }
            board.add(sb.toString());
        }
        return board;
    }
}