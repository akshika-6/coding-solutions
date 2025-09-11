class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] pair:prerequisites){
            int dest=pair[0];
            int src=pair[1];
            graph.get(src).add(dest);
            indegree[dest]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int visited=0;
        while(!q.isEmpty()){
            int node = q.poll();
            visited++;
            for(int nei:graph.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return visited == numCourses;
    }
}
        