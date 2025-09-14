class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int x=flowerbed.length;
        for(int i=0;i<x;i++){
            if(flowerbed[i] == 0){
                int prev = (i==0) ? 0 : flowerbed[i-1];
                int next = (i==x-1) ? 0 : flowerbed[i+1];
                if(prev == 0 && next == 0){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        return n<=0;
    }
}