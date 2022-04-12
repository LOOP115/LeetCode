public class ClimbingStairs {

    // Attempt 1  递归  到 45 超时了，需要用 memo
    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    public static int climbStairsMemo(int n, int[] memo) {
        switch (n) {
            case 1 -> memo[n] = 1;
            case 2 -> memo[n] = 2;
            default -> memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
        return memo[n];
    }

    // 动态规划  O(n)  100%
    public static int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 使用滚动数组进行动态规划
    public static int climbStairs2(int n) {
        int oneStep;
        int twoStep = 0;
        int ways = 1;
        for (int i=1; i<=n; i++) {
            oneStep = twoStep;
            twoStep = ways;
            ways = oneStep + twoStep;
        }
        return ways;
    }

    // Fibonacci + 矩阵快速幂  O(logn)  100%
    public static int climbStairs3(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public static int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    // Binet's Formula  P(logn)  100%
    public static int climbStairs4(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }


    public static void main(String[] args) {
        System.out.println(climbStairs4(45));
    }

}
