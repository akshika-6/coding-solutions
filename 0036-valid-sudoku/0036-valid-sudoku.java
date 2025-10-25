class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                    int boxIndex = (i / 3) * 3 + (j / 3); // Box number 0-8

                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false; // Duplicate found
                    }

                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }
        return true;
    }
}