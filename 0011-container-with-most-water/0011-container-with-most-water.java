class Solution {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        while(left < right){
            int width = right - left;
            int h = Math.min(height[left],height[right]);
            maxarea = Math.max(maxarea, h * width);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxarea;
    }
}