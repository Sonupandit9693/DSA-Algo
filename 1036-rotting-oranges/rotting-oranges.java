class Pair{
    int row;
    int col;
    int tm;
    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<Pair>();
        int cntfresh = 0;
        int [][] vis = new int [n][m];

        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }else if(grid[i][j] == 1){
                    cntfresh ++;
                }
            }
        }

        int tm = 0;
        int cnt = 0;

        int[] delrow = {-1, 1, 0, 0};
        int[] delcol = {0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col  = p.col;
            int time = p.tm;

            tm = Math.max(tm, time);

            for(int i=0; i<4; i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                    q.add(new Pair(nrow, ncol, time + 1));
                    vis[nrow][ncol] = 2;
                    cnt ++;
                }

            }
        }

        if (cnt != cntfresh){
            return -1;
        }

        return tm;
    }
}