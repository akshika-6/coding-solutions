class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefix = 0, count = 0;
        for(int i = 0;i<nums.length;i++){
            prefix+=nums[i];
            int rem = prefix%k;
            if(rem < 0) rem += k;
            count += map.getOrDefault(rem,0);
            map.put(rem,map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}