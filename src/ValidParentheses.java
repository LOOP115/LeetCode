import java.util.*;

public class ValidParentheses {

    // Attempt 1  Stack  98.84%
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        if (n % 2 != 0) {
            return false;
        }
        for (char c: s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                switch (c) {
                    case ')' -> {
                        if (temp != '(') return false;
                    }
                    case ']' -> {
                        if (temp != '[') return false;
                    }
                    case '}' -> {
                        if (temp != '{') return false;
                    }
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    // 官方解法，思路一样
    public static boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    // 评论区比较秒的思路，运行效率较低
    public static boolean isValid2(String s) {
        while(true){
            int l=s.length();
            s=s.replace("()","");
            s=s.replace("{}","");
            s=s.replace("[]","");
            if(s.length()==l){return l==0;}
        }
    }


    public static void main(String[] args) {
        String test = "{}";
        System.out.println(isValid(test));
    }

}
