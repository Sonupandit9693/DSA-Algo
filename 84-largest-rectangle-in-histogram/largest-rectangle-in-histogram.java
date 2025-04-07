class Solution {
    public int largestRectangleArea(int[] heights) {
        // we declear a stack to store bar 
        Stack<Integer> stack = new Stack<>();

        int max_area = 0;
        int n = heights.length;

        for(int i=0; i<=n; i++){
            int currHeight = (i == n) ? 0: heights[i];
            
            // System.out.println("\nCurrent index: " + i + ", Height: " + currHeight);
            // System.out.println("Stack before: " + stack);

            // check in stack peek element 
            while(! stack.isEmpty() && currHeight < heights[stack.peek()]){
                int topIndex = stack.pop();
                int height = heights[topIndex];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                max_area = Math.max(max_area, area);

                // System.out.println("  -> Popped index: " + topIndex + ", height: " + height);
                // System.out.println("     Width: " + width + ", Area: " + area);
                // System.out.println("     Max Area so far: " + max_area);
            }
            stack.push(i);
            // System.out.println("Stack after: " + stack);
        }

        // System.out.println("\nFinal Max Area: " + max_area);
        return max_area;
    }
}