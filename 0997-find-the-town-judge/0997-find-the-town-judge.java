class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] indegree = new int[n+1];
        int[] outdegree=new int[n+1];
        for(int i=0;i<trust.length;i++){
            int x=trust[i][0];
            int y=trust[i][1];
            outdegree[x]++;
            indegree[y]++;
        }
        for(int i=1;i<=n;i++){
            if(outdegree[i] == 0 && indegree[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}