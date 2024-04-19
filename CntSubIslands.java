class Solution {
    private int[][] grid1;
    private boolean isSubIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;

        int subIslands = 0;

        int m = grid2.length;
        int n = grid2[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    dfs(i, j, grid2);
                    if (isSubIsland) {
                        subIslands++;
                    }
                }
            }
        }

        return subIslands;
    }

    private void dfs(int row, int col, int[][] grid2) {
        int m = grid2.length;
        int n = grid2[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || grid2[row][col] == 0) {
            return;
        }

        grid2[row][col] = 0;
        if (grid1[row][col] == 0) {
            isSubIsland = false;
        }

        dfs(row - 1, col, grid2);
        dfs(row + 1, col, grid2);
        dfs(row, col - 1, grid2);
        dfs(row, col + 1, grid2);
    }
}
