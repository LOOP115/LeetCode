public class DecodeWays {

    // Space O(n)  35.59%
    public static int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Case 1: Use 1 char
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Case 2: Use 2 char
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') < 27)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    // 优化: 不用维护数组
    // Space O(1)  100%
    public static int numDecodings1(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int a = 0; // f(i-2)
        int b = 1; // f(i-1)
        int c = 0; // fi
        for (int i = 1; i <= n; i++) {
            c = 0;
            // Case 1: Use 1 char
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            // Case 2: Use 2 char
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') < 27)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }


    public static void main(String[] args) {
        String test = "27";
        System.out.println(numDecodings(test));
    }

}
