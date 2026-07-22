import java.util.*;

class Solution {

    static class Group {
        int start;
        int length;

        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    static class ZeroInfo {
        List<Group> groups;
        int[] index;

        ZeroInfo(List<Group> groups, int[] index) {
            this.groups = groups;
            this.index = index;
        }
    }

    static class SparseTable {
        int[][] st;
        int n;

        SparseTable(int[] nums) {
            n = nums.length;

            if (n == 0) {
                st = new int[1][1];
                return;
            }

            int k = 32 - Integer.numberOfLeadingZeros(n);
            st = new int[k][n];

            for (int i = 0; i < n; i++) {
                st[0][i] = nums[i];
            }

            for (int i = 1; i < k; i++) {
                for (int j = 0; j + (1 << i) <= n; j++) {
                    st[i][j] = Math.max(
                            st[i - 1][j],
                            st[i - 1][j + (1 << (i - 1))]
                    );
                }
            }
        }

        int query(int l, int r) {
            int len = r - l + 1;
            int p = 31 - Integer.numberOfLeadingZeros(len);

            return Math.max(
                    st[p][l],
                    st[p][r - (1 << p) + 1]
            );
        }
    }

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {

        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        ZeroInfo info = getZeroGroups(s);
        List<Group> zeroGroups = info.groups;
        int[] zeroGroupIndex = info.index;

        List<Integer> ans = new ArrayList<>();

        if (zeroGroups.size() == 0) {
            for (int i = 0; i < queries.length; i++) {
                ans.add(totalOnes);
            }
            return ans;
        }

        SparseTable sparseTable =
                new SparseTable(getZeroMergeLengths(zeroGroups));

        for (int[] q : queries) {

            int l = q[0];
            int r = q[1];

            int left =
                    zeroGroupIndex[l] == -1
                            ? -1
                            : zeroGroups.get(zeroGroupIndex[l]).length
                            - (l - zeroGroups.get(zeroGroupIndex[l]).start);

            int right =
                    zeroGroupIndex[r] == -1
                            ? -1
                            : r - zeroGroups.get(zeroGroupIndex[r]).start + 1;

            int startAdjacent = zeroGroupIndex[l] + 1;

            int endAdjacent =
                    s.charAt(r) == '1'
                            ? zeroGroupIndex[r] - 1
                            : zeroGroupIndex[r] - 2;

            int best = totalOnes;

            if (s.charAt(l) == '0'
                    && s.charAt(r) == '0'
                    && zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {

                best = Math.max(best, totalOnes + left + right);
            }
            else if (startAdjacent <= endAdjacent) {

                best = Math.max(
                        best,
                        totalOnes + sparseTable.query(startAdjacent, endAdjacent)
                );
            }

            if (s.charAt(l) == '0'
                    && zeroGroupIndex[l] + 1 <=
                    (s.charAt(r) == '1'
                            ? zeroGroupIndex[r]
                            : zeroGroupIndex[r] - 1)) {

                best = Math.max(
                        best,
                        totalOnes
                                + left
                                + zeroGroups.get(zeroGroupIndex[l] + 1).length
                );
            }

            if (s.charAt(r) == '0'
                    && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {

                best = Math.max(
                        best,
                        totalOnes
                                + right
                                + zeroGroups.get(zeroGroupIndex[r] - 1).length
                );
            }

            ans.add(best);
        }

        return ans;
    }

    private ZeroInfo getZeroGroups(String s) {

        List<Group> groups = new ArrayList<>();
        int[] index = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '0') {

                if (i > 0 && s.charAt(i - 1) == '0') {
                    groups.get(groups.size() - 1).length++;
                } else {
                    groups.add(new Group(i, 1));
                }
            }

            index[i] = groups.size() - 1;
        }

        return new ZeroInfo(groups, index);
    }

    private int[] getZeroMergeLengths(List<Group> groups) {

        int m = groups.size();

        if (m <= 1) return new int[0];

        int[] merge = new int[m - 1];

        for (int i = 0; i < m - 1; i++) {
            merge[i] =
                    groups.get(i).length
                            + groups.get(i + 1).length;
        }

        return merge;
    }
}