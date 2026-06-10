class Solution {
    public int longestOnes(int[] nums, int k) {
        int zerocount = 0;
        int left = 0;;
        int right = 0;
        int maxans = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                zerocount++;
            }
            right++;
            while(left < right && zerocount > k){
                if(nums[left] == 0){
                    zerocount--;
                }
                left++;
            }
            maxans = Math.max(maxans, right-left);
        }
        return maxans;
    }
}