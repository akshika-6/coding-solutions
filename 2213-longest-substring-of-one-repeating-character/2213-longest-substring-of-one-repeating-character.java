class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int len;

        Node() {}

        Node(char c) {
            leftChar = c;
            rightChar = c;
            prefix = 1;
            suffix = 1;
            best = 1;
            len = 1;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            arr[index] = newChar;

            update(1, 0, n - 1, index, newChar);

            answer[i] = tree[1].best;
        }

        return answer;
    }

    // ---------------- BUILD ----------------

    private void build(int node, int start, int end) {

        if (start == end) {
            tree[node] = new Node(arr[start]);
            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------- UPDATE ----------------

    private void update(
            int node,
            int start,
            int end,
            int index,
            char c) {

        if (start == end) {
            tree[node] = new Node(c);
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, c);
        } else {
            update(node * 2 + 1, mid + 1, end, index, c);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    // ---------------- MERGE ----------------

    private Node merge(Node left, Node right) {

        Node result = new Node();

        result.len = left.len + right.len;

        result.leftChar = left.leftChar;
        result.rightChar = right.rightChar;

        // Start with independent values
        result.prefix = left.prefix;
        result.suffix = right.suffix;

        result.best = Math.max(left.best, right.best);

        // Can the suffix of left connect with
        // the prefix of right?
        if (left.rightChar == right.leftChar) {

            result.best = Math.max(
                    result.best,
                    left.suffix + right.prefix
            );

            // Entire left segment has same character
            if (left.prefix == left.len) {
                result.prefix = left.len + right.prefix;
            }

            // Entire right segment has same character
            if (right.suffix == right.len) {
                result.suffix = right.len + left.suffix;
            }
        }

        return result;
    }
}