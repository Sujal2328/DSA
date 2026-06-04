class Solution {
    public int numEnclaves(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        
         for(int col = 0;col<m;col++){
            if(grid[0][col] == 1 && visited[0][col] == 0){
                dfs(0,col,grid,visited);
            }
          }
          for(int col=0;col<m;col++){
            if(grid[n-1][col] == 1 && visited[n-1][col] == 0){
                dfs(n-1,col,grid,visited);
            }
          }
           for(int row = 0;row<n;row++){
            if(grid[row][0] == 1 && visited[row][0] == 0){
                dfs(row,0,grid,visited);
            }
          }
           for(int row = 0;row<n;row++){
            if(grid[row][m-1] == 1 && visited[row][m-1] == 0){
                dfs(row,m-1,grid,visited);
            }
          }
          int cnt = 0;
        for(int row =0;row<n;row++){
            for(int col = 0;col<m;col++){
                if(grid[row][col] == 1 && visited[row][col] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void dfs(int row,int col,int[][] grid, int[][] visited){
        visited[row][col] = 1;
      
      int n = grid.length;
      int m = grid[0].length;
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol <m && grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
                dfs(nrow,ncol,grid,visited);
            }
        }
    }
}