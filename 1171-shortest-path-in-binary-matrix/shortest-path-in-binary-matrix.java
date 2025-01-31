class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // If the start or end cell is blocked, return -1
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        
        // Directions for 8 possible moves
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };
        
        // BFS queue storing (row, col, path length)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        grid[0][0] = 1; // Mark as visited
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1], pathLength = cell[2];
            
            // If we reached the bottom-right cell, return path length
            if (row == n - 1 && col == n - 1) return pathLength;
            
            // Explore all 8 possible directions
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0) {
                    queue.offer(new int[]{newRow, newCol, pathLength + 1});
                    grid[newRow][newCol] = 1; // Mark as visited
                }
            }
        }
        
        return -1; // No path found
    }
}