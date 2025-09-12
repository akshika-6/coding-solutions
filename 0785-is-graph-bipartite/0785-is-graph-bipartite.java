class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n]; // 0 = uncolored, 1 = red, -1 = blue

        for (int start = 0; start < n; start++) {
            if (color[start] != 0) continue; // already visited

            // start BFS
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            color[start] = 1; // assign first color

            while (!queue.isEmpty()) {
                int node = queue.poll();

                for (int neighbor : graph[node]) {
                    if (color[neighbor] == 0) {
                        // assign opposite color
                        color[neighbor] = -color[node];
                        queue.offer(neighbor);
                    } else if (color[neighbor] == color[node]) {
                        // same color conflict
                        return false;
                    }
                }
            }
        }
        return true;
    }
}