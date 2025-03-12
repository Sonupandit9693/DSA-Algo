class Solution {

    private static final int[] delrow = {-1, 0, 1, 0};
    private static final int[] delcol = {0, 1, 0, -1};
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        // start dfs from 'O' from the boundry and mark them True

        for(int i=0; i<n; i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, board);
            }

            if(board[i][m-1] == 'O'){
                dfs(i, m-1, board);
            }
        }

        for(int j=0; j<m; j++){
            if(board[0][j] == 'O'){
                dfs(0, j, board);
            }
            if(board[n-1][j] == 'O'){
                dfs(n-1, j, board);
            }
        }


        //convert remaing 'O' to 'X' (captures regions)
        // convert True back to False (boundry connected regions)

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    private void dfs(int row, int col, char[][] board){
        int n = board.length, m = board[0].length;

        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O'){
            return;
        }

        board[row][col]= 'T';
        for(int i=0; i<4; i++){
            dfs(row + delrow[i], col + delcol[i], board);
        }
    }
}