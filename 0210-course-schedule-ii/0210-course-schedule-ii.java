class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[V];
        for(int[] i:prerequisites){
            graph.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] ans=new int[V];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++] = node;
            for(int i:graph.get(node)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return (idx == V) ? ans : new int[0];
    }
}