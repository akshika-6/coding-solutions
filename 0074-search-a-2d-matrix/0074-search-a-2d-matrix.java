class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // int m = matrix.length;
        // int n = matrix[0].length;

        // int left = 0, right = m * n - 1;

        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     int midValue = matrix[mid / n][mid % n];

        //     if (midValue == target) {
        //         return true;
        //     } else if (midValue < target) {
        //         left = mid + 1;
        //     } else {
        //         right = mid - 1;
        //     }
        // }

        // return false;


        int m=matrix.length;
        int n=matrix[0].length;

        int l=0;
        int r=m*n-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            int midvalue = matrix[mid/n][mid%n];
            if(midvalue == target){
                return true;
            } else if(midvalue < target){
                l = mid +1;
            }else{
                r=mid-1;
            }
        }
        return false;
    }
}