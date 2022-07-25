public class BackspaceStringCompare {

    // 官方: 双指针  逆序遍历  Space: O(1)  100%
    public static boolean backspaceCompare(String s, String t) {
        int lenS = s.length(), lenT = t.length();
        int i = lenS - 1, j = lenT - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            // 找到 s 中第一个待比较的字符
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // 找到 t 中第一个待比较的字符
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            // 开始比较
            if (i >= 0 && j >= 0) {
                // char 不同
                if (s.charAt(i) != t.charAt(j)) return false;
                // i < 0 && j >= 0
                // j < 0 && i >= 0
                // 以上两种情况都为 false
            } else if (i >= 0 || j >= 0) return false;
            i--;
            j--;
        }
        // i < 0 && j < 0: 都为 empty string  true
        return true;
    }


    // 官方: 重构 String  Time & Space: O(N + M)
    public static boolean backspaceCompare2(String s, String t) {
        return removeBackSpace(s).equals(removeBackSpace(t));
    }

    public static String removeBackSpace(String s) {
        StringBuilder res = new StringBuilder();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c != '#') {
                res.append(c);
            } else {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "ada#d#";
        String t = "ad";
        System.out.println(backspaceCompare(s, t));
    }
}
