class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]});
        }

        // dist[node] = shortest time to reach node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap (cost, node)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];

            if (time > dist[node]) continue; // skip outdated entry

            for (int[] nei : adj.get(node)) {
                int v = nei[0], w = nei[1];
                if (time + w < dist[v]) {
                    dist[v] = time + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        // find maximum shortest time
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}