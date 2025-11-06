class Solution {
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) parent[pb] = pa;
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        DSU dsu = new DSU(c);

        // Step 1: Union all connected stations
        for (int[] conn : connections) {
            dsu.union(conn[0], conn[1]);
        }

        // Step 2: Map root → TreeSet of online stations
        Map<Integer, TreeSet<Integer>> groups = new HashMap<>();
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        for (int i = 1; i <= c; i++) {
            int root = dsu.find(i);
            groups.computeIfAbsent(root, k -> new TreeSet<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        // Step 3: Process queries
        for (int[] q : queries) {
            int type = q[0], x = q[1];
            int root = dsu.find(x);

            if (type == 1) { // maintenance check
                if (online[x]) {
                    result.add(x);
                } else {
                    TreeSet<Integer> set = groups.get(root);
                    if (set == null || set.isEmpty()) result.add(-1);
                    else result.add(set.first());
                }
            } else { // station goes offline
                if (online[x]) {
                    TreeSet<Integer> set = groups.get(root);
                    if (set != null) set.remove(x);
                    online[x] = false;
                }
            }
        }

        // Convert List<Integer> → int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}