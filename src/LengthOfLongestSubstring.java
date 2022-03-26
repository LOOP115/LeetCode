import java.util.HashSet;
import java.util.Set;
import java.lang.Math;

public class LengthOfLongestSubstring {

    // 官方 Sliding window  O(N)  48.92%
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> occ = new HashSet<Character>();
        int ans = 0;
        // 右指针初始位置在开头之前
        int right = -1;
        for (int i=0; i<n; i++) {
            // 移动左指针前删除 set 中右指针前一位的字符
            if (i != 0) {
                occ.remove(s.charAt(i - 1));
            }
            // 寻找从当前右指针开始的最长的 substring
            while (right < n - 1 && !occ.contains(s.charAt(right + 1))) {
                occ.add(s.charAt(right + 1));
                right++;
            }
            // 更新最长 substring 的长度
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }

    // 评论区 100% 解法，没有用 set，而是用数组来确定每个字符上一次出现的位置
    public static int lengthOfLongestSubstring1(String s) {
        // 记录每个字符上一次出现的位置
        // 本题中没有明确说明字符集，因此可以默认为所有 ASCII 码在 [0,128) 内的字符
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }

}
