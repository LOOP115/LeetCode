public class SumOfSquareNumbers {

    // Attempt1: 双指针  O(sqrt(c))  91.33%
    public static boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // 官方题解 3: 费马平方和  100%
    // 一个非负整数 c 如果能够表示为两个整数的平方和，当且仅当 c 的所有形如 4k + 3 的质因子的幂均为偶数
    // Prove: https://wstein.org/edu/124/lectures/lecture21/lecture21/node2.html
    public boolean judgeSquareSum1(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }

            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }

        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }


    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147482647));
    }

}
