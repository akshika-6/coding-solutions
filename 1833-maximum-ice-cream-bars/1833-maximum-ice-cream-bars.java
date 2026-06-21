class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxcost = 0;
        int n = costs.length;
        for(int i = 0;i<n;i++){
            maxcost = Math.max(maxcost,costs[i]);
        }
        int freq[] = new int[maxcost+1];
        for(int cost:costs){
            freq[cost]++;
        }
        int count = 0;
        for(int cost=1;cost<=maxcost;cost++){
            if(freq[cost] == 0){
                continue;
            }
            int canbuy = Math.min(freq[cost], coins/cost);

            count += canbuy;
            coins -= canbuy*cost;

            if(coins < cost){
                continue;
            }
        }
        return count;
    }
}