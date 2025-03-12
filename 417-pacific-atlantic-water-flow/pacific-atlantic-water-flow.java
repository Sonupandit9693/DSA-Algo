class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length , n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> result = new ArrayList<>();

        // Traves first and last column
        for(int i=0; i<m; i++){
            // dfs call for marking oceans True
            dfs(heights, pacific, i, 0, Integer.MIN_VALUE);
            dfs(heights, atlantic, i , n-1, Integer.MIN_VALUE);
        }

        // Travers first and last row
        for(int j=0; j<n; j++){
            dfs(heights, pacific, 0, j, Integer.MIN_VALUE);
            dfs(heights, atlantic, m-1, j, Integer.MIN_VALUE);
        }

        //collect cells that can flow to both ocean
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int i, int j, int prevHeight){
        int m = heights.length , n = heights[0].length;
        // base case when go out of bound or already visited ocean or height condition voilated

        if( i < 0 || j < 0 || i >= m || j >= n || ocean[i][j] || heights[i][j] < prevHeight){
            return;
        }

        ocean[i][j] = true;

        // explore for all four direction
        dfs(heights, ocean, i + 1, j, heights[i][j]);
        dfs(heights, ocean, i-1, j, heights[i][j]);
        dfs(heights, ocean, i, j+1, heights[i][j]);
        dfs(heights, ocean, i, j-1, heights[i][j]);
    }
}