class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int n = arr.length;
        // curr is the value we want to place at index curr-1
        for (int curr = n; curr > 1; curr--) {
            // find index of value curr
            int idx = findIndex(arr, curr);
            if (idx == curr - 1) {
                // already in correct place
                continue;
            }
            // if curr is not already at front, flip to bring it to front
            if (idx != 0) {
                flip(arr, idx + 1);
                res.add(idx + 1);
            }
            // flip to move curr to its final position
            flip(arr, curr);
            res.add(curr);
        }
        return res;
    }
    private void flip(int[] arr, int k) {
        int i = 0, j = k - 1;
        while (i < j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++; j--;
        }
    }

    // find index of value val in arr (values are 1..n and unique)
    private int findIndex(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        return -1;
    }
}