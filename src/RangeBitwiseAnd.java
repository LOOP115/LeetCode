public class RangeBitwiseAnd {

    // 位移 O(logn)  100%
    public static int rangeBitwiseAnd1(int left, int right) {
        int shift = 0;
        // 位移到公共前缀
        while (left != right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // 公共前缀后补零
        return left << shift;
    }

    // Brian Kernighan 算法  O(logn)  100%
    // 每次 n & n - 1 之后, n 最右边的 1 会被抹去成 0
    public static int rangeBitwiseAnd2(int left, int right) {
        // 找到公共前缀
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }


    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd1(4, 7));
        System.out.println(rangeBitwiseAnd2(4, 7));
    }

}
