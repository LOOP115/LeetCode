public class NumberOfOneBits {

    // Solution 1  循环检查每一位是否为 1  100%
    public static int hammingWeight1(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }

    // Solution 2  观察这个运算：n & (n−1)，其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果  100%
    public static int hammingWeight2(int n) {
        int ret = 0;
        // 不断运算 n & (n−1) 直到所有 1 被消耗完
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(hammingWeight2(3));
    }

}
