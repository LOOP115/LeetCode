public class ReverseBits {

    // Attempt 1  100%
    public static int reverseBits(int n) {
        int res = 0;
        for (int i=0; i<32; i++) {
            if ((n & (1 << i)) != 0) {
                res += (1 << (31 - i));
            }
        }
        return res;
    }

    // Solution 1  思路和上面差不多，倒序添加
    public static int reverseBits1(int n) {
        int res = 0;
        for (int i=0; i<32 && n!=0; i++) {
            // 检查当前首位是否为 1，如果是 1 就添加入结果
            res |= (n & 1) << (31 - i);
            // Right shift n，如果 n 为零，可以 break
            n >>>= 1;
        }
        return res;
    }

    // Solution 2  位运算分治
    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public static int reverseBits2(int n) {
        // 取出所有奇数位和偶数位
        // 将奇数位移到偶数位上，偶数位移到奇数位上
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M4 | (n & M4) << 4;
        n = n >>> 8 & M8 | (n & M8) << 8;
        return n >>> 16 | n << 16;
    }


    public static void main(String[] args) {
        System.out.println(reverseBits2(43261596));
    }

}
