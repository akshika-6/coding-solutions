class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]}); // (to, weight)
        }

        // Step 2: Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 3: Min-heap {time, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});

        // Step 4: Visited array
        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];

            if (visited[node]) continue; // already finalized
            visited[node] = true;

            for (int[] nei : adj.get(node)) {
                int v = nei[0], w = nei[1];
                if (dist[v] > time + w) {
                    dist[v] = time + w;
                    pq.add(new int[]{dist[v], v});
                }
            }
        }

        // Step 5: Find max shortest path
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) return -1; // unreachable node
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}