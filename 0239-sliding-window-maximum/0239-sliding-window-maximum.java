class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(k == 1){
            return nums;
        }
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] ans = new int[n-k+1];

        for(int i = 0;i<n;i++){
            if(i%k == 0){
                pre[i] = nums[i];
            } else {
                pre[i] = Math.max(nums[i],pre[i-1]);
            }
        }
        for(int i = n-1;i>=0;i--){
            if(i == n-1 || (i+1)%k == 0){
                suf[i] = nums[i];
            } else {
                suf[i] = Math.max(nums[i],suf[i+1]);
            }
        }
        for(int i = 0;i<ans.length;i++){
            ans[i] = Math.max(suf[i],pre[i+k-1]);
        }
        return ans;
    }
}