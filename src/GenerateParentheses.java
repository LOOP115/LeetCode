import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    // Attempt 1: Backtracking  100%
    public static char start = '(';
    public static char end = ')';

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder t = new StringBuilder();
        backtrack(ans, t, n, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder t, int startCnt, int endCnt) {
        if (startCnt == 0 && endCnt == 0) {
            ans.add(t.toString());
            return;
        }
        if (startCnt > 0) {
            t.append(start);
            backtrack(ans, t, startCnt - 1, endCnt);
            t.deleteCharAt(t.length() - 1);
        }
        if (endCnt > startCnt) {
            t.append(end);
            backtrack(ans, t, startCnt, endCnt - 1);
            t.deleteCharAt(t.length() - 1);
        }
    }


    // 官方: 按括号序列的长度递归
    // 每一个括号序列可以用 (a)b 来表示，其中 a 与 b 分别是一个合法的括号序列 (可以为空)
    public static ArrayList[] cache = new ArrayList[100];

    public static List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left: generate(c)) {
                    for (String right: generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public static List<String> generateParenthesis1(int n) {
        return generate(n);
    }


    // 官方暴力法
    public List<String> generateParenthesisBrute(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    public boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') {
                ++balance;
            } else {
                --balance;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis1(3));
    }

}
