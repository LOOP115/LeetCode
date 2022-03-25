public class ArrangeCoins {

    // 等差数列  O(logn) 97.93%
    public static int arrangeCoins(int n) {
        int low = 0, high = n >>> 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long sum = (long) mid * (mid + 1) / 2;
            if (sum  == n) {
                return mid;
            } else if (sum > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if ((long) low * (low + 1) / 2 > n) {
            return low - 1;
        } else {
            return low;
        }
    }

    // 官方等差数列
    public static int arrangeCoins1(int n) {
        int left = 1, right = n;
        while (left < right) {
            // 先加1再除以2是为了让中间值靠右，因为在后序对右边的值处理是 right = mid - 1
            int mid = (left + right + 1) >>> 1;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 解方程  97.93%
    public static int arrangeCoins2(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }

    // 评论区看到的一个有趣的解法，虽然时间很慢
    public static int arrangeCoins3(int n) {
        int res = 0;
        while (n - res > 0)
            n -= ++res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
        for (int i=1; i<=15; i++) {
            System.out.println("n = " + i + " " + arrangeCoins(i) + " complete rows.");
        }
    }

}
