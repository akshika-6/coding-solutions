class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
       int left = 0;
       int right = nums.length-1;
        if (n == 1) return 0;
       while(left < right){
        int mid = left + (right-left)/2;
        if(nums[mid] < nums[mid+1]){
            left = mid+1;
        } else{
            right = mid;
        }
       }
       return left;
    }
}