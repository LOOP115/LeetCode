public class PowerOfTwo {

    // Solution 1  n & (n - 1)
    // e.g. n = 3 = 0011  n-1 = 0010  n&(n-1) = 0010
    // e.g. n = 4 = 0100  n-1 = 0011  n&(n-1) = 0000
    public static boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    // Solution 2  n & (-n)
    // e.g. n = 3 = 0011  -n = 1100 + 0001 = 1101  n&(-n) = 0001
    // e.g. n = 4 = 0100  -n = 0011 + 0001 = 1100  n&(-n) = 0100
    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (-n)) == n;
    }

    // Solution 3  取巧，判断是否为 2^30 的约数
    public static final int BIG = 1 << 30;

    public static boolean isPowerOfTwo3(int n) {
        return n > 0 && BIG % n == 0;
    }


    public static void main(String[] args) {
        System.out.println(isPowerOfTwo2(2));
    }

}
