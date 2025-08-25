class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Iterate through each point in the input array
        for (int[] point : points) {
            // Calculate the squared Euclidean distance from the origin
            int distanceSquared = point[0] * point[0] + point[1] * point[1];
            
            // Add an array containing the distance and the point's coordinates to the heap
            maxHeap.offer(new int[]{distanceSquared, point[0], point[1]});
            
            // If the heap size exceeds k, remove the element with the largest distance
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // The heap now contains the k closest points.
        // Extract them into the result array.
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] topElement = maxHeap.poll();
            // We only need the coordinates (at index 1 and 2), not the distance
            result[i] = new int[]{topElement[1], topElement[2]};
        }
        
        return result;
    }
}