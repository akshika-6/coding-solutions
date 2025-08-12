/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
//         TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
//         m_pre(root,0,map);
//         return new ArrayList<>(map.values());
//     }
//     public void m_pre(TreeNode root, int hd, TreeMap<Integer,ArrayList<Integer>> map){
//         if(root != null){
//             if(!map.containsKey(hd)){
//                 map.put(hd,new ArrayList<>());
//             }
//             map.get(hd).add(root.val);
//             m_pre(root.left,hd-1,map);
//             m_pre(root.right,hd+1,map);
//         }
//     }
// }


if (root == null) return new ArrayList<>();

        TreeMap<Integer, List<int[]>> colMap = new TreeMap<>();
        Queue<Triple> q = new LinkedList<>();
        q.offer(new Triple(root, 0, 0)); // col = 0, row = 0

        while (!q.isEmpty()) {
            Triple t = q.poll();
            TreeNode node = t.node;
            int col = t.col;
            int row = t.row;

            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(new int[]{row, node.val});

            if (node.left != null) q.offer(new Triple(node.left, col - 1, row + 1));
            if (node.right != null) q.offer(new Triple(node.right, col + 1, row + 1));
        }

        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> nodes : colMap.values()) {
            // Sort by row, then by value
            nodes.sort((a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });

            List<Integer> colList = new ArrayList<>();
            for (int[] pair : nodes) colList.add(pair[1]);
            result.add(colList);
        }

        return result;
    }

    static class Triple {
        TreeNode node;
        int col;
        int row;
        Triple(TreeNode n, int c, int r) {
            node = n;
            col = c;
            row = r;
        }
    }
}