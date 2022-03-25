public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        int low = 1, high = num + 1 >>> 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midPower = (long) mid * mid;
            if (midPower == num) {
                return true;
            } else if (midPower < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    // 同Sqrt，也可以用牛顿迭代求解
    public boolean isPerfectSquareNewton(int num) {
        double x0 = num;
        while (true) {
            double x1 = (x0 + num / x0) / 2;
            if (x0 - x1 < 1e-6) {
                break;
            }
            x0 = x1;
        }
        int x = (int) x0;
        return x * x == num;
    }


    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

}
