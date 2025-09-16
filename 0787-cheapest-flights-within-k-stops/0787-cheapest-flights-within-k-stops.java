class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]}); // {to, price}
        }

        // Min-heap: {cost so far, city, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src, 0});

        // dist[city][stops] = min cost to reach city with 'stops'
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], node = cur[1], stops = cur[2];

            if (node == dst) return cost; // Found cheapest

            if (stops > k) continue; // can't exceed k stops

            for (int[] nei : adj.get(node)) {
                int next = nei[0], price = nei[1];
                int newCost = cost + price;

                if (newCost < dist[next][stops + 1]) {
                    dist[next][stops + 1] = newCost;
                    pq.add(new int[]{newCost, next, stops + 1});
                }
            }
        }
        return -1;
    }
}