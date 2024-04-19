class Solution {
    int max=0;
    int add=0;
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    dfs(i,j,grid,n,m);
                }
                add=0;
            }
        }
        return max;

    }
    void dfs(int i ,int j,int grid[][],int n,int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0 ){
            max=Math.max(max,add);
            return ;
        }
        add=add+grid[i][j];
        grid[i][j]=0;
        max=Math.max(max,add);
        dfs(i-1,j,grid,n,m);
        dfs(i+1,j,grid,n,m);
        dfs(i,j-1,grid,n,m);
        dfs(i,j+1,grid,n,m);
    }
}
