public class UniquePaths {

    // Attempt 1: DP  100%  O(mn)
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 边界均设为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 从左上方走来
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 官方 组合数  100%
    // 从左上角到右下角的过程中，我们需要移动 m + n - 2 次，其中有 m - 1 次向下移动，n - 1 次向右移动
    // 因此路径的总数 = 从 m + n - 2 次移动中选择 m - 1 次向下移动的方案数
    public int uniquePathsComb(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
