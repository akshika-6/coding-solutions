class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int m = matrix.length;
        // int n = matrix[0].length;
        
        // int row = 0, col = n - 1; // start at top-right
        
        // while (row < m && col >= 0) {
        //     if (matrix[row][col] == target) {
        //         return true;
        //     } else if (matrix[row][col] > target) {
        //         col--; // move left
        //     } else {
        //         row++; // move down
        //     }
        // }
        
        // return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n-1;
        while(row < m && col >= 0){
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
}