class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        List<Boolean> res = new ArrayList<>();
        for(int i: candies){
            if(i > max) max = i;
        }
        max = Math.abs(extraCandies-max);
        for(int i: candies){
            if(i >= max){
                res.add(true);
            } else{
                res.add(false);
            }
        }
        return res;
    }
}