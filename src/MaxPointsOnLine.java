import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    // Hashtable  O(n^2 logm)  61.16%
    public int maxPoints(int[][] points) {
        int n = points.length;
        // 两点构成一条直线
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            // 当我们找到一条直线经过了图中超过半数的点时，我们即可以确定该直线即为经过最多点的直线
            // 当我们枚举到 i 时，至多只能找到 n - i 个点共线。假设此前找到的共线的点的数量的最大值为 k，如果 k >= n - i，停止枚举。
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<>();
            // 只需要考虑编号 > i 的点，之前的点已经被枚举过
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                // 处理浮点误差
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    // Greatest common divisor  O(logm)  m = 横纵坐标最大差值
    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
