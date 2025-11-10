class Solution {
    static class SegTree {
        int n;
        int[] tree;
        SegTree(int[] arr) {
            n = arr.length;
            tree = new int[4*n];
            build(1, 0, n-1, arr);
        }
        void build(int node, int l, int r, int[] arr) {
            if (l == r) {
                tree[node] = arr[l];
            } else {
                int mid = (l+r)/2;
                build(node*2, l, mid, arr);
                build(node*2+1, mid+1, r, arr);
                tree[node] = Math.min(tree[node*2], tree[node*2+1]);
            }
        }
        int queryMin(int node, int l, int r, int ql, int qr) {
            if (ql > r || qr < l) return Integer.MAX_VALUE;
            if (ql <= l && r <= qr) return tree[node];
            int mid = (l+r)/2;
            return Math.min(queryMin(node*2, l, mid, ql, qr),
                            queryMin(node*2+1, mid+1, r, ql, qr));
        }
        int queryMin(int l, int r) { return queryMin(1, 0, n-1, l, r); }
    }

    // Map from value -> sorted list of positions where it appears
    static Map<Integer, ArrayList<Integer>> posMap;
    static SegTree seg;

    // Recursion: compute ops for [l,r] inclusive (assume all > 0 in this segment)
    static int solveRange(int l, int r) {
        if (l > r) return 0;
        int minVal = seg.queryMin(l, r);
        // find positions of minVal that lie in [l,r]
        ArrayList<Integer> idxs = posMap.get(minVal);
        // binary search first index >= l
        int lo = 0, hi = idxs.size()-1, start = idxs.size();
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (idxs.get(mid) >= l) {
                start = mid; hi = mid-1;
            } else lo = mid+1;
        }
        int ops = 1; // this operation removes all minVal occurrences inside [l,r]
        int prev = l;
        // iterate indices while <= r
        for (int k = start; k < idxs.size(); ++k) {
            int p = idxs.get(k);
            if (p > r) break;
            // solve between prev..p-1
            ops += solveRange(prev, p-1);
            prev = p+1;
        }
        // last tail
        ops += solveRange(prev, r);
        return ops;
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Build posMap
        posMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            posMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        seg = new SegTree(nums);

        int total = 0;
        // process contiguous blocks of positive numbers (non-zero),
        // zeros are useless because min in a range containing 0 is 0 (no effect)
        int i = 0;
        while (i < n) {
            while (i < n && nums[i] == 0) i++;
            if (i >= n) break;
            int start = i;
            while (i < n && nums[i] != 0) i++;
            int end = i - 1;
            total += solveRange(start, end);
        }
        return total;
    }
}