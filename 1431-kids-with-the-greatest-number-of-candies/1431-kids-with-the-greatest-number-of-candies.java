class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (max < candies[i]) {
                max = candies[i];
            }
        }
        ArrayList<Boolean> res=new ArrayList<>();
        int limit=max-extraCandies;
        for(int i:candies){
            if(i >= limit){
                res.add(true);
            } else{
                res.add(false);
            }
        }
        return res;
    }
}