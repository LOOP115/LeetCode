public class EditDistance {

    // 本质不同的操作实际上只有三种
    // 在单词 A 中插入一个字符
    // 在单词 B 中插入一个字符
    // 修改单词 A 的一个字符
    // O(mn)  87.84%
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Empty String
        if (m * n == 0) {
            return m + n;
        }
        int[][] dp = new int[m + 1][n + 1];

        // Base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // DP
        for (int i = 1; i <= m; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                int dist1 = dp[i - 1][j] + 1; // A 的前 i 个字符和 B 的前 j-1 个字符的编辑距离
                int dist2 = dp[i][j - 1] + 1; // A 的前 i-1 个字符和 B 的前 j 个字符的编辑距离
                int dist3 = dp[i - 1][j - 1]; // A 的前 i-1 个字符和 B 的前 j-1 个字符的编辑距离
                if (c1 != c2) {
                    // A 的第 i 个字符和 B 的第 j 个字符相同，不需要进行 replace 操作
                    // 其他情况需要一次操作
                    dist3++;
                }
                dp[i][j] += Math.min(dist1, Math.min(dist2, dist3));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        System.out.println(minDistance(s1, s2));
    }

}
