class Solution {
    int[][] dirs;
    int m,n;
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        this.dirs=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        this.n = grid.length;
        this.m = grid[0].length;
        
        if (grid[row][col]==color)
            return grid;
        
        boolean[][] visited = new boolean[n][m];
        dfs(grid, row, col, grid[row][col], visited, color);
        
        return grid;
    }
    public void dfs(int[][] grid, int i, int j, int color, boolean[][] visited, int target){
        
        if (i>n-1 || i<0 || j>m-1 || j<0 || grid[i][j]!=color || visited[i][j])
            return;
        visited[i][j] = true;
        boolean border = false;
        
        if (i==0 || j==0 || j==m-1 || i==n-1 || grid[i+1][j]!=color || grid[i-1][j]!=color || grid[i][j-1]!=color || grid[i][j+1]!=color)
            border = true;
        
        for(int[] dir: dirs){
            int nr=i+dir[0];
            int nc=j+dir[1];
            dfs(grid, nr, nc, color, visited, target);
        }
        if (border)
            grid[i][j] = target;
    }
}
