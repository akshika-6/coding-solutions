class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            StringBuilder st = new StringBuilder();
            for(int j = 0;j<n;j++){
                st.append(grid[i][j]).append(",");
            }
            String a = st.toString();
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int ans = 0;
        for(int i = 0;i<n;i++){
            StringBuilder st = new StringBuilder();
            for(int j = 0;j<n;j++){
                st.append(grid[j][i]).append(",");
            }
            String a = st.toString();
            ans += map.getOrDefault(a,0);
        }
        return ans;
    }
}