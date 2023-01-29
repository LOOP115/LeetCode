import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // O(n^2) 51.30%
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // HashSet 检查是否存在速度更快
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int right = 1; right <= n; right++) {
            for (int left = 0; left < right; left++) {
                if (dp[left] && dict.contains(s.substring(left, right))) {
                    dp[right] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        List<String> dict1 = new ArrayList<>();
        dict1.add("leet");
        dict1.add("code");
        System.out.println(wordBreak(s1, dict1));
    }

}
