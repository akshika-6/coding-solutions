class Solution {
    public int largestRectangleArea(int[] heights) {
         /* int n = heights.length;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            int h = heights[i];
            int area = 0;
            for(int j=0; j<n; j++) {
                if(heights[j] >= h) {
                    area += h;
                    max = Math.max(max, area);
                }else {
                    area = 0;
                }
            }
        }

        return max; */

        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()]>heights[i]) {
                int h = heights[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                int area = right-left-1;
                maxArea = Math.max(maxArea, area*h);
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int r = n;
            int h = heights[st.pop()];
            int l = st.isEmpty() ? -1 : st.peek();
            int area = r-l-1;
            maxArea = Math.max(maxArea, area*h);
        }

        return maxArea;
    }
}