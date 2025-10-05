class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result=new ArrayList<>();
        if(heights == null || heights.length == 0) return result;
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            dfs(heights,pacific,Integer.MIN_VALUE,i,0,direction);
            dfs(heights,atlantic,Integer.MIN_VALUE,i,n-1,direction);
        }
        for(int j=0;j<m;j++){
            dfs(heights,pacific,Integer.MIN_VALUE,0,j,direction);
            dfs(heights,atlantic,Integer.MIN_VALUE,m-1,j,direction);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
    public static void dfs(int[][] heights,boolean[][] visited,int prevheight,int r,int c,int[][] directions){
        int m=heights.length;
        int n=heights[0].length;
        if(r<0 || c<0 || r>=m || c>=n){
            return;
        }
        if(visited[r][c]){
            return;
        }
        if(heights[r][c] < prevheight) return;
        visited[r][c]=true;
        for(int[] dir:directions){
            dfs(heights,visited,heights[r][c],r+dir[0],c+dir[1],directions);
        }
    }
}