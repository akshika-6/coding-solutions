class Solution {
    public int majorityElement(int[] nums) {
        int c=0;
        int candidate=0;
        for(int num:nums){
            if(c == 0){
                candidate=num;
            }
            if(num == candidate){
                c+=1;
            } else{
                c-=1;
            }
        }
        return candidate;
    }
}