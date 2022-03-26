import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    // Solution 1: Sliding Window  78.66%
    public static boolean checkInclusion1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        // 使用两个数组分别记录两个 String 中各个字符的个数
        // 题目规定只有 lower case letters
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i=0; i<n1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }

        // 继续滑动 s2 的余下字符
        for (int i=n1; i<n2; i++) {
            // 删除当前窗口的第一个字符
            count2[s2.charAt(i - n1)- 'a']--;
            // 将新的字符加入窗口
            count2[s2.charAt(i) - 'a']++;
            // 判断当前窗口是否匹配 s1
            if (Arrays.equals(count1, count2)) {
                return true;
            }
        }
        return false;
    }

    // 优化 Solution 1: 记录diff，免去每次都比较整个数组  O(n1+n2+26)  78.66%
    public static boolean checkInclusion2(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }

        // 记录各个字符出现次数的差
        int[] count = new int[26];
        for (int i=0; i<n1; i++) {
            count[s1.charAt(i)- 'a']--;
            count[s2.charAt(i)- 'a']++;
        }

        // 计算差的总和
        int diff = 0;
        for (int i: count) {
            if (i != 0) {
                diff++;
            }
        }
        if (diff == 0) {
            return true;
        }

        // 在 s2 中继续滑动窗口
        for (int i=n1; i<n2; i++) {
            // 当前窗口的第一位
            int toDelete = s2.charAt(i - n1) - 'a';
            // 新窗口的最后一位
            int newLast = s2.charAt(i) - 'a';
            if (toDelete == newLast) {
                continue;
            }
            // 新加的元素是多余的
            if (count[newLast] == 0) {
                diff++;
            }
            // Add newLast
            count[newLast]++;
            // 新加元素之后该元素差为零，总差降低
            if (count[newLast] == 0) {
                diff--;
            }
            // 窗口第一位原本差为零
            if (count[toDelete] == 0) {
                diff++;
            }
            // Remove toDelete
            count[toDelete]--;
            // 窗口第一位删除后该元素差为零，总差降低
            if (count[toDelete] == 0) {
                diff--;
            }
            // 比较新窗口和 s1
            if (diff == 0) {
                return true;
            }
        }
        return false;
    }

    // Solution 2: 双指针，保证 cnt 的值不为正的情况下，去考察是否存在一个区间，其长度恰好为 n  O(n1+n2+26)  97.15%
    public static boolean checkInclusion3(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 > n2) {
            return false;
        }
        // 记录 s1 中所有字符出现次数的负数
        int[] cnt = new int[26];
        for (int i=0; i<n1; i++) {
            cnt[s1.charAt(i) - 'a']--;
        }
        int left = 0;
        for (int right = 0; right < n2; right++) {
            int x = s2.charAt(right) - 'a';
            cnt[x]++;
            // x 如果为正说明 s1 中不存在 x，因此移动左指针直到 x 的值为非正
            while (cnt[x] > 0) {
                cnt[s2.charAt(left) - 'a']--;
                left++;
            }

            // 判断左右指针间隔是否正好为 s1 的长度
            if (right - left + 1 == n1) {
                return true;
            }
        }
        return false;
    }

    // 评论区 100%，个人认为比官方最快的双指针方法更加容易理解
    public static boolean checkInclusion4(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[] charCount = new int[26]; // 【总欠账表】：s1的词频表
        for (char c : str1) { // 统计s1的词频
            charCount[c - 'a']++;
        }
        int l = 0, r = 0; // 滑动窗口左右边界
        // 依次尝试固定以s2中的每一个位置l作为左端点开始的len1长度的子串s2[l ... l+len1)是否是s1的排列
        while (l <= len2 - len1) { // 固定左端点只需要尝试到len2-len1即可
            // 右边界s2[r]字符进入窗口【还账】，如果还不了就不进
            while (r < l + len1 && charCount[str2[r] - 'a'] >= 1) {
                charCount[str2[r] - 'a']--; // 【"还账"】
                r++;
            }
            if (r == l + len1) return true;
            // 左边界s2[l]字符出窗口【赊账】，l++，开始尝试固定下一个位置做左端点
            charCount[str2[l] - 'a']++; // 重新【"赊账"】
            l++;
        }
        return false; // 所有的左端点均尝试还账失败，不可能再有答案了
    }

    // Attempt 1: 想通过 Hasp Map 解决，实际速度很慢
    public static boolean checkInclusion(String s1, String s2) {
        // 对 s1 构建 Hash Map
        int n1 = s1.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<n1; i++) {
            char c = s1.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        // 遍历 s2
        int n2 = s2.length();
        for (int i=0; i<n2; i++) {
            char c = s2.charAt(i);
            // 判断 c 是否出现在 s1 中
            int count = map.getOrDefault(c,0);
            if (count != 0) {
                // c 出现在 s1 中，构建一个新的 Hash Map，将 c 先存入
                Map<Character, Integer> tempMap = new HashMap<>();
                tempMap.put(c, 1);
                // 从 c 后一位开始遍历
                for (int j=i+1; j<n2; j++) {
                    // 遍历长度等于 n1，break
                    if (j - i == n1) {
                        break;
                    }
                    char cc = s2.charAt(j);
                    // 判断 cc 是否存在于 s1
                    int inMap = map.getOrDefault(cc, 0);
                    if (inMap == 0) {
                        break;
                    } else {
                        // 将 cc 存入 Hash Map
                        int tempCount = tempMap.getOrDefault(cc, 0) + 1;
                        tempMap.put(cc, tempCount);
                    }
                }
                // 判断两个 Map 是否相等
                if (map.equals(tempMap)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion3(s1, s2));
    }

}
