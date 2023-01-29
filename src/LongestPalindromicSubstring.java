import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    // DP  43.45%
    // P(i, i) = true
    // p(i, i + 1) = (Si == Si+1)
    // p(i, j) = p(i + 1, j - 1) && (Si == Sj)
    // Time & Space: O(n^2)
    public static String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        // 所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] letters = s.toCharArray();
        for (int l = 2; l <= len; l++) {
            for (int left = 0; left < len; left++) {
                int right = left + l - 1;
                if (right >= len) {
                    break;
                }

                if (letters[left] != letters[right]) {
                    dp[left][right] = false;
                } else {
                    if (right - left < 2) {
                        // Base case
                        dp[left][right] = true;
                    } else {
                        // 动态规划，向外扩展
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }
                // 更新最长回文串
                if (dp[left][right] && (right - left + 1) > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    // Solution 2: 中心扩展  85.47%
    // 基于两种边界情况（1 或 2）中心扩展
    // Time O(n^2)
    // Space O(1)
    public static String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.max(expandCenter(s, i, i), expandCenter(s, i, i + 1));
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    // Solution 3: Manacher O(n) 过于复杂
    public String longestPalindromeManacher(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }


    public static void main(String[] args) {
        String s1 = "bb";
        System.out.println(longestPalindrome1(s1));
    }

}
