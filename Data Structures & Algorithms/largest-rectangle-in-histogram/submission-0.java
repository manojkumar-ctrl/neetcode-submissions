class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] leftsmall = new int[n];
        int[] rightsmall = new int[n];

        // Nearest smaller element on left
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.isEmpty())
                leftsmall[i] = -1;
            else
                leftsmall[i] = st.peek();

            st.push(i);
        }

        st.clear();

        // Nearest smaller element on right
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.isEmpty())
                rightsmall[i] = n;
            else
                rightsmall[i] = st.peek();

            st.push(i);
        }

        int maxarea = 0;

        for(int i = 0; i < n; i++) {

            int width = rightsmall[i] - leftsmall[i] - 1;

            int area = heights[i] * width;

            maxarea = Math.max(maxarea, area);
        }

        return maxarea;
    }
}