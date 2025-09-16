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
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        UnionFind uf=new UnionFind(n);
        for(int[] i:edges){
            if(uf.union(i[0],i[1]) == false){
                return i;
            }
        }
        return new int[0];
    }
}