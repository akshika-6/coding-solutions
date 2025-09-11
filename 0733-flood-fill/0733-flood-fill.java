class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalc=image[sr][sc];
        if(originalc == color){
            return image;
        }
        dfs(sr,sc,image,originalc,color);
        return image;
    }
    public static void dfs(int sr,int sc,int[][] image,int originalc,int color){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalc){
            return;
        }
        image[sr][sc]=color;
        dfs(sr+1,sc,image,originalc,color);
        dfs(sr-1,sc,image,originalc,color);
        dfs(sr,sc+1,image,originalc,color);
        dfs(sr,sc-1,image,originalc,color);
    }
}