class Solution {
    public int nthUglyNumber(int n) {
        // PriorityQueue<Integer> pq= new PriorityQueue<>();
        // pq.add(1);
        // for(int i=1;i<=n;i++){
        //     int ele = pq.poll();

        // }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>(); // To avoid duplicates

        pq.add(1L);
        seen.add(1L);

        long ugly = 1;

        for (int i = 0; i < n; i++) {
            ugly = pq.poll(); // smallest ugly number
            
            // Generate next multiples
            if (seen.add(ugly * 2)) pq.add(ugly * 2);
            if (seen.add(ugly * 3)) pq.add(ugly * 3);
            if (seen.add(ugly * 5)) pq.add(ugly * 5);
        }
        
        return (int) ugly;
    }
}