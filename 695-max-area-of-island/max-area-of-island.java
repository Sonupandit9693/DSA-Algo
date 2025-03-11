class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i < rows; i++){
            for(int j=0; j < cols; j++){
                // check if cell is island or not 
                if(grid[i][j] == 1){
                    // check area of island
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid){
        // check base case
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 0;
        }

        grid[i][j] = 0; // mark as visited
        int area = 1;

        // and check for all four direction
        area += dfs(i+1, j, grid);
        area += dfs(i-1, j, grid);
        area += dfs(i, j+1, grid);
        area += dfs(i, j-1, grid);

        return area;
    }
}