class Solution {
    public void solve(char[][] board) {
          int n = board.length;
          int m = board[0].length;

          int[][] visited = new int[n][m];

          for(int col = 0;col<m;col++){
            if(board[0][col] == 'O' && visited[0][col] == 0){
                dfs(0,col,board,visited);
            }
          }
          for(int col=0;col<m;col++){
            if(board[n-1][col] == 'O' && visited[n-1][col] == 0){
                dfs(n-1,col,board,visited);
            }
          }
           for(int row = 0;row<n;row++){
            if(board[row][0] == 'O' && visited[row][0] == 0){
                dfs(row,0,board,visited);
            }
          }
           for(int row = 0;row<n;row++){
            if(board[row][m-1] == 'O' && visited[row][m-1] == 0){
                dfs(row,m-1,board,visited);
            }
          }
          for(int row=0;row<n;row++){
            for(int col =0;col<m;col++){
                if(board[row][col] == 'O' && visited[row][col] ==0){
                    board[row][col] ='X';
                }
            }
          }
    }
    public void dfs(int row,int col, char[][] board,int[][] visited){
        visited[row][col] = 1;
           int n = board.length;
           int m = board[0].length;
        int[] delrow={-1,0,1,0};
        int[] delcol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nrow = row+delrow[i];
            int ncol = col + delcol[i];
 
          if(nrow>=0 && nrow<n && ncol>=0 && ncol< m && visited[nrow][ncol] == 0 && 
             board[nrow][ncol] == 'O' ){
                dfs(nrow,ncol,board,visited);
          }
        }
    }
}