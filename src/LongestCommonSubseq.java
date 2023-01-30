public class LongestCommonSubseq {

    // DP  O(mn) 52.01%
    // 边界: 空字符串和任何字符串的最长公共子序列的长度都是 0
    // dp[i][j] 表示 text1[0:i] 和 text[0:j] 的最长公共子序列长度
    // 因为只利用两行的数据，可优化为滚动数组，降低复杂度
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        String s1 = "bl";
        String s2 = "yby";
        System.out.println(longestCommonSubsequence(s1, s2));
    }

}
