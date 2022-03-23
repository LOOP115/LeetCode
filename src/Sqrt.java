import java.lang.Math;

public class Sqrt {

    public static int mySqrt(int x) {
        int low = 1;
        int high = (x - low) / 2 + low;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int divide = x / mid;
            if (divide == mid) {
                return mid;
            } else if (divide < mid) {
                // Search left portion
                high = mid - 1;
            } else {
                // Search right portion
                low = mid + 1;
            }
        }
        return low-1;
    }

    public static int mySqrtCalculator(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static int mySqrtBinary(int x) {
        int l = 0, r = x, ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static int mySqrtNewton(int x) {
        if (x == 0) {
            return 0;
        }

        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
        System.out.println(mySqrtCalculator(2147395600));
        System.out.println(mySqrtBinary(2147395600));
        System.out.println(mySqrtNewton(2147395600));
    }

}
