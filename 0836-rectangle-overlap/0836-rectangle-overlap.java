class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int xLeft = Math.max(rec1[0], rec2[0]);
        int xRight = Math.min(rec1[2], rec2[2]);
        
        int yBottom = Math.max(rec1[1], rec2[1]);
        int yTop = Math.min(rec1[3], rec2[3]);
        
        return xLeft < xRight && yBottom < yTop;
    }
}