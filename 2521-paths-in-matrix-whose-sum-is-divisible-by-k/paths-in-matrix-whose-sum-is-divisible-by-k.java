class Solution {
    public int numberOfPaths(int[][] grid, int k) {
       int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][k];
        int firstNum = grid[0][0] % k;
        dp[1][1][firstNum] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int x = 0; x < k; x++) {
                    int sum = (grid[i - 1][j - 1] + x) % k;
                    int numPaths = (dp[i - 1][j][x] + dp[i][j - 1][x]) % MOD;
                    dp[i][j][sum] = (dp[i][j][sum] + numPaths) % MOD;
                }
            }
        }

        return dp[m][n][0]; 
    }
}