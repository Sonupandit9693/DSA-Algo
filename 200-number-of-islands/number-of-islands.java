class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public static void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));

        int n = grid.length;      // Number of rows
        int m = grid[0].length;   // Number of columns

        // Directions for moving up, down, left, and right
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            // Explore all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                // Check bounds, land presence, and visited status
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;      // Number of rows
        int m = grid[0].length;   // Number of columns

        int[][] vis = new int[n][m]; // Corrected size of the `vis` array
        int cnt = 0; // Count of islands

        // Traverse the grid
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // If it's unvisited land, start a BFS
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++; // Found a new island
                    bfs(row, col, vis, grid);
                }
            }
        }

        return cnt; // Return the total count of islands
    }
}
