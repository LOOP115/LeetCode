import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramsInString {

    // Solution 1: Sliding Window  88.19%
    // Time: O(m + (n-m)*26)
    // Space: O(26)
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen > sLen) {
            return res;
        }

        // Create Hash Table using array
        int[] sCnt = new int[26];
        int[] pCnt = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCnt, pCnt)) {
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            // Remove previous counts
            sCnt[s.charAt(i) - 'a']--;
            // Counts in new window
            sCnt[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCnt, pCnt)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    // Solution 2: Improvement of Solution 1
    // Use difference to compare
    public static List<Integer> findAnagrams1(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }

        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    // 评论区解法  88.19%
    public static List<Integer> findAnagrams2(String s, String p) {
        int[] cnt = new int[128];
        for (char c : p.toCharArray()) cnt[c]++;
        int lo = 0, hi = 0;
        List<Integer> res = new ArrayList<>();
        // 该循环确保[lo, hi)的区间中的出现的字符总是p的一个子集
        // PS1: "na"是"and"的子集，而"nn"则不是"and"的子集
        // PS2: 除了评论中那个边际条件，前面已经有评论解释过了
        while (hi < s.length()) {
            if (cnt[s.charAt(hi)] > 0) {
                // 子集条件满足，右移增大窗口
                cnt[s.charAt(hi++)]--;
                // 窗口长度 == p.len，且窗口内字符是p的子集
                // <=> (充要条件) s.substring(lo, hi)是p的同字母异序词
                if (hi - lo == p.length()) res.add(lo);
            } else {
                // 再右移hi不可能满足子集条件，
                // 右移左边界lo、复位计数器，直到这个条件（子集条件）再次满足
                cnt[s.charAt(lo++)]++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        String s2 = "abab";
        String p2 = "ab";
        System.out.println(findAnagrams2(s2, p2));
    }

}
