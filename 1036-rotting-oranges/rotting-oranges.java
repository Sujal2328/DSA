class Solution {
    class Pair{
    int row;
    int col;
     Pair(int row,int col){
        this.row = row;
        this.col = col;
     }
    }
    public int orangesRotting(int[][] grid) {
        int n  =grid.length;
        int m = grid[0].length;
        Queue<Pair> q  = new LinkedList<>();
        int fresh = 0;
        for(int row=0;row<n;row++){
            for(int col =0;col<m;col++){
                if(grid[row][col]==2){
                    q.offer(new Pair(row,col));
                }
                if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }
        int min =0;
        
        int delrow[] = {-1,0,1,0};
        int delcol[] = {0,1,0,-1};

        while(!q.isEmpty() && fresh>0){
              int size = q.size();

            for(int i = 0; i < size; i++) {

                Pair curr = q.poll();

                int row = curr.row;
                int col = curr.col;

                // 4 directions check karo
                for(int k = 0; k < 4; k++) {

                    int nrow = row + delrow[k];
                    int ncol = col + delcol[k];

                    // Valid fresh orange mila?
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol < m && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                          fresh--;
                        q.offer(new Pair(nrow, ncol));
                    }
                }
            }

            min++;
        }

    return fresh == 0 ? min : -1;
    }
}