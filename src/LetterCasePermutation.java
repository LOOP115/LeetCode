import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {

    // Attempt 1  Backtracking  100%
    public static List<String> letterCasePermutation(String s) {
        char[] temp = new char[s.length()];
        List<String> ans = new ArrayList<String>();
        int i = 0;
        for (char c: s.toCharArray()) {
            temp[i] = c;
            i++;
        }
        int len = s.length();
        backtrack(len ,0, temp, ans);
        return ans;
    }

    public static void backtrack(int len, int first, char[] temp, List<String> ans) {
        if (first == len) {
            ans.add(String.valueOf(temp));
        }

        for (int i=first; i<len; i++) {
            char c = temp[i];
            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    temp[i] = Character.toUpperCase(c);
                    backtrack(len, first + 1, temp, ans);
                    temp[i] = Character.toLowerCase(c);
                } else {
                    temp[i] = Character.toLowerCase(c);
                    backtrack(len, first + 1, temp, ans);
                    temp[i] = Character.toUpperCase(c);
                }
            }
            first++;
            if (i == len - 1) {
                ans.add(String.valueOf(temp));
            }
        }
    }

    // Solution 1
    // 如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，
    // 在第一份的每个字符串末尾添加 lowercase(c)，在第二份的每个字符串末尾添加 uppercase(c)。
    // 如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾。
    public static List<String> letterCasePermutation1(String S) {
        List<StringBuilder> ans = new ArrayList();
        ans.add(new StringBuilder());

        for (char c: S.toCharArray()) {
            int n = ans.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; ++i) {
                    ans.add(new StringBuilder(ans.get(i)));
                    ans.get(i).append(Character.toLowerCase(c));
                    ans.get(n+i).append(Character.toUpperCase(c));
                }
            } else {
                for (int i = 0; i < n; ++i)
                    ans.get(i).append(c);
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: ans)
            finalans.add(sb.toString());
        return finalans;
    }

    // Solution 2  二分掩码  是我一开始的思路，但没想出来怎么实现，用位运算实现非常巧妙
    public  static List<String> letterCasePermutation2(String S) {
        int B = 0;
        for (char c: S.toCharArray())
            if (Character.isLetter(c))
                B++;

        List<String> ans = new ArrayList();

        for (int bits = 0; bits < 1<<B; bits++) {
            int b = 0;
            StringBuilder word = new StringBuilder();
            for (char letter: S.toCharArray()) {
                if (Character.isLetter(letter)) {
                    if (((bits >> b++) & 1) == 1)
                        word.append(Character.toLowerCase(letter));
                    else
                        word.append(Character.toUpperCase(letter));
                } else {
                    word.append(letter);
                }
            }
            ans.add(word.toString());
        }
        return ans;
    }

    // 评论区递归，思路和自己差不多，代码更精简  100%
    public static List<String> letterCasePermutation3(String S) {
        List<String> res = new ArrayList<>();
        char[] chs = S.toCharArray();
        int n = chs.length;
        dfs(chs, n, 0, res);
        return res;
    }

    public static void dfs(char[] chs, int n, int begin, List<String> res) {
        res.add(new String(chs));
        for(int i = begin; i < n; i++){
            if(Character.isAlphabetic(chs[i])){
                char tmp = chs[i];
                chs[i] = (char)(chs[i] - 'a' >= 0 ? chs[i] - 32 : chs[i] + 32);
                dfs(chs, n, i + 1, res);
                chs[i] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation3(s));
    }

}
