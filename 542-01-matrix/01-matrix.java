import java.util.*;

class Pair {
    int first;
    int second;
    int edge;

    Pair(int first, int second, int edge) {
        this.first = first;
        this.second = second;
        this.edge = edge;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] dis = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        // Intializw value 1 assign edge with 0 in dis matrix 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.first;
            int col = p.second;
            int step = p.edge;

            // Update distance for the current cell
            dis[row][col] = step;

            // Check all 4 directions
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                // Validate the new position and if it's not visited
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    q.add(new Pair(nrow, ncol, step + 1));
                    vis[nrow][ncol] = 1;
                }
            }
        }

        return dis;
    }
}
