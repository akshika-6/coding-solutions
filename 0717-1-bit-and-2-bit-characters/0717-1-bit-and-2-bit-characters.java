class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        if(n < 2) return true;
        if(bits[n-1] == 0){
            if(bits[n-2] == 1){
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
}