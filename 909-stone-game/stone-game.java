class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=piles[i];
        }
          for (int len = 2; len <= n; len++) {

            for (int left = 0; left + len - 1 < n; left++) {

                int right = left + len - 1;

               
              int  takeleft = piles[left]-dp[left+1][right];
               int  takeright = piles[right]-dp[left][right-1];
                

                dp[left][right] = Math.max(takeleft,takeright);
            }
        }

        return dp[0][n - 1] > 0;
    }
}