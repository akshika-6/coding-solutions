class UnionFind{
    int parent[];
    int rank[];
    UnionFind(int V){
        parent = new int[V+1];
        rank = new int[V+1];
        for(int i=0;i<V;i++){
            parent[i]=i;
        }
    }
    int find(int node){
        if(parent[node] == node) return node;
        return find(parent[node]);
    }
    boolean union(int u,int v){
        int pu=find(u);
        int pv=find(v);
        if(pu == pv){
            return false;
        }
        if(rank[pu] > rank[pv]){
            parent[pv]=pu;
        } else if(rank[pv] > rank[pu]){
            parent[pu]=pv;
        } else{
            parent[pv]=pu;
            pu++;
        }
        return true;
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        UnionFind uf=new UnionFind(V);
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<V;i++){
            if(uf.find(i) == i){
                c++;
            }
        }
        return c;
    }
}