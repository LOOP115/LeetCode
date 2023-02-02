import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class HappyNumber {

    public static int getNext(int n) {
        int sum  = 0;
        while (n > 0) {
            int d = n % 10;
            n /= 10;
            sum += d * d;
        }
        return sum;
    }

    // Solution 1: Use Hash Set  O(logn)  82.48%
    public static boolean isHappy1(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    // Solution 2: 快慢指针  O(logn)  Space: O(1)  100%
    public static boolean isHappy2(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    // Solution 3: Math  Hardcode
    // 硬解循环链路，要么在进入 1 的路上，要么在此循环链路
    private static Set<Integer> cycleMembers = new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));
    public static boolean isHappy3(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }

}
