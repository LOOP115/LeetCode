public class IntegerBreak {

    // DP  O(n^2)  79.34%
    // i = j + (i - j)
    // 1. i - j 不再拆分
    // 2. i - j 继续拆分
    public static int integerBreak1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    // Math & DP  O(n)  100%
    // 证明可得: 只需要考虑 j = 2 和 j = 3 的情况
    public static int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];
    }

    // Math  证明详见官方题解  O(1)  100%
    public static int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }


    public static void main(String[] args) {
        System.out.println(integerBreak1(2));
    }

}
