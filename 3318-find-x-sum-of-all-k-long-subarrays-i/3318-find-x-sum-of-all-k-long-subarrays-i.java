class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            // count frequency for subarray nums[i..i+k-1]
            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            // sort elements by frequency desc, value desc
            List<int[]> list = new ArrayList<>();
            for (int key : freq.keySet()) {
                list.add(new int[]{key, freq.get(key)});
            }
            list.sort((a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            // choose top x frequent elements
            Set<Integer> keep = new HashSet<>();
            for (int idx = 0; idx < Math.min(x, list.size()); idx++) {
                keep.add(list.get(idx)[0]);
            }

            // sum of elements that are in 'keep'
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                if (keep.contains(nums[j])) sum += nums[j];
            }

            ans[i] = sum;
        }

        return ans;
    }
}