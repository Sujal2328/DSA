class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        int[][] visited = new int[n][m];
        int count = 0;

        for(int row= 0 ;row<n;row++){
            for(int col = 0 ;col<m;col++){
                if(visited[row][col] == 0 && grid[row][col] == '1'){
                  dfs(row,col,visited,grid);
                  count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row,int col,int[][] visited,char[][] graph){
        visited[row][col] = 1;
        int n = graph.length;
        int m = graph[0].length;
        for(int delrow = -1;delrow<=1;delrow++){
            for(int delcol = -1;delcol<=1;delcol++){
                 if (Math.abs(delrow) + Math.abs(delcol) != 1) {
                    continue;
                }
                int nrow = row + delrow;
                int ncol  =col + delcol;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0 && graph[nrow][ncol] == '1'){
                    dfs(nrow,ncol,visited,graph);
                }
            }
        }
    }
}