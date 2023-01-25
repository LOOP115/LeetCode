import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhone {

    // Attempt 1  100%
    public static Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        // StringBuffer is slower than StringBuilder
        // The reason behind this is StringBuffer synchronization
        // - only allowing 1 thread to execute on an object at a time results in much slower code execution.
        StringBuilder t = new StringBuilder();
        char[] digitsChar = digits.toCharArray();
        backtrack(ans, t, digitsChar, 0);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder t, char[] digitsChar, int len) {
        if (len == digitsChar.length) {
            ans.add(t.toString());
            return;
        }
        char cur = digitsChar[len];
        for (char c: phoneMap.get(cur).toCharArray()) {
            t.append(c);
            backtrack(ans, t, digitsChar, len + 1);
            t.deleteCharAt(t.length() - 1);
        }
    }


    public static void main(String[] args) {
        String test = "23";
        System.out.println(letterCombinations(test));
    }

}
