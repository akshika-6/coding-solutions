class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]}); // (to, price)
        }

        // dist[node] = min cost to reach node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Queue: (node, cost, stops)
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], cost = cur[1], stops = cur[2];

            if (stops <= k){ // can't go beyond k stops

            for (int[] nei : adj.get(node)) {
                int v = nei[0], price = nei[1];
                if (cost + price < dist[v]) {
                    dist[v] = cost + price;
                    q.add(new int[]{v, dist[v], stops + 1});
                }
            }
        }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}