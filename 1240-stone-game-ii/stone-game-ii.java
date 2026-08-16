class Solution {
    public int stoneGameII(int[] piles) {

        int n = piles.length;

       
        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int M, int[] piles,
                      int[] suffix, int[][] dp) {

        if (i >= piles.length) {
            return 0;
        }

        if (2 * M >= piles.length - i) {
            return suffix[i];
        }

    
        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int opponent = Integer.MAX_VALUE;

        int taken = 0;


        for (int X = 1; X <= 2 * M; X++) {

            taken += piles[i + X - 1];

            int nextM = Math.max(M, X);
      opponent = Math.min(
                opponent,
                solve(i + X, nextM, piles, suffix, dp)
            );
        }

      
        dp[i][M] = suffix[i] - opponent;

        return dp[i][M];
    }
}