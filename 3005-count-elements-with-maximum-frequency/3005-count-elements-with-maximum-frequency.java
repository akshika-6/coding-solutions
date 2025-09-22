class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq=new int[101];
        int max=0;
        for(int i:nums){
            freq[i]++;
            max=Math.max(max,freq[i]);
        }
        int res=0;
        for(int f:freq){
            if(f == max){
                res+=f;
            }
        }
        return res;
    }
}