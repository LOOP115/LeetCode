import java.util.*;

public class FirstUniqueChar {

    // Solution 1  使用一个哈希表记录频率，遍历两次 String
    public static int firstUniqChar1(String s) {
        int n = s.length();
        HashMap<Character, Integer> cnt = new HashMap<>();
        // 第一次遍历记录频率
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        // 第二次遍历找到第一个 uniq char 即可 return
        for (int i=0; i<n; i++) {
            if (cnt.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    // Solution 2  依旧使用哈希表，二次遍历的对象从字符串变为哈希映射
    public static int firstUniqChar2(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (position.containsKey(ch)) {
                position.put(ch, -1);
            } else {
                position.put(ch, i);
            }
        }
        int first = n;
        for (Map.Entry<Character, Integer> entry : position.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }

    // Attempt 1  使用两个哈希表，速度很慢
    public static int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> cnt = new HashMap<>();
        HashMap<Character, Integer> uniq = new HashMap<>();
        char[] ss = s.toCharArray();
        for (int i=0; i<n; i++) {
            char c = ss[i];
            int count = cnt.getOrDefault(c, 0) + 1;
            cnt.put(c, count);
            if (count == 1) {
                uniq.put(c, i);
            } else {
                uniq.remove(c);
            }
        }
        if (uniq.isEmpty()) {
            return -1;
        }
        return Collections.min(uniq.values());
    }

    // 由于哈希表运行速度较慢，可以改为用数组计数，思路一样  91.77%
    public static int firstUniqChar0(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    // Solution 3  利用队列 FIFO
    public static int firstUniqChar3(String s) {
        Map<Character, Integer> position = new HashMap<Character, Integer>();
        Queue<Pair> queue = new LinkedList<Pair>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            // 新的 uniq char 入列
            if (!position.containsKey(ch)) {
                position.put(ch, i);
                queue.offer(new Pair(ch, i));
            } else {
                // 有重复 char
                position.put(ch, -1);
                // 延迟删除
                // 即使队列中有一些字符出现了超过一次，但它只要不位于队首，那么就不会对答案造成影响，我们也就可以不用去删除它。
                // 只有当它前面的所有字符被移出队列，它成为队首时，我们才需要将它移除。
                while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                    queue.poll();
                }
            }
        }
        // 队首即为答案
        return queue.isEmpty() ? -1 : queue.poll().pos;
    }

    public static class Pair {
        char ch;
        int pos;

        Pair(char ch, int pos) {
            this.ch = ch;
            this.pos = pos;
        }
    }


    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar1(s));
    }

}
