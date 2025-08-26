class Solution {
    class Pair {
        String word;
        int count;
        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        HashMap<String, Integer> map = new HashMap<>();
        for (String st : words) {
            map.put(st, map.getOrDefault(st, 0) + 1);
        }

        // Step 2: Min-heap with comparator
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return b.word.compareTo(a.word); 
                // larger word removed first, smaller word stays
            }
            return a.count - b.count; 
            // lower frequency removed first
        });

        // Step 3: Push entries into heap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
            if (pq.size() > k) pq.poll();
        }

        // Step 4: Extract results (reverse order to get highest freq first)
        ArrayList<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        Collections.reverse(res);

        return res;
    }
}