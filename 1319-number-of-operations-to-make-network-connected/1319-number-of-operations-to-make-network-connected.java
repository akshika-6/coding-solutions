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
    public int makeConnected(int n, int[][] connections) {
        int cables = connections.length;
        int pc=n;
        if(cables < pc-1){
            return -1;
        }
        UnionFind uf=new UnionFind(n);
        for(int[] i:connections){
            uf.union(i[0],i[1]);
        }
        int c=0;
        for(int i=0;i<n;i++){
            if(uf.find(i) == i){
                c++;
            }
        }
        return c-1;
    }
}