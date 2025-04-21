class Solution {
    public int largestRectangleArea(int[] heights) {
        // monotonic stack approach
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        for(int i=0; i<=n; i++){
            int currHeight = (i == n ? 0 : heights[i]);

            while(! stack.isEmpty() && currHeight < heights[stack.peek()]){
                int top = stack.pop();
                int height = heights[top];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                int area = height * width;
                max_area = Math.max(max_area, area);
            }

            stack.push(i);
        }

        return max_area;
    }
}