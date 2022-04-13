import java.util.List;

public class Triangle {

    // 自下而上动态规划所有节点的路径  O(n^2)  O(n)
    // f[i][j] = min(f[i+1][j], f[i+1][j+1]) + c[i][j]
    // 自下而上不需要考虑边界问题，代码也简洁很多  96.09%
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];
        // 自下而上规划
        for (int i=n-1; i>=0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j=0; j<=i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + row.get(j);
            }
        }
        return dp[0];
    }

    // 自上而下动态规划所有节点的路径  O(n^2)
    // f[i][0] = f[i-1][0] + c[i][0]
    // f[i][i] = f[i-1][i-1] + c[i][i]
    // f[i][j] = min(f[i-1][j-1], f[i-1][j]) + c[i][j]
    // 可以用递减枚举从而只需要一个长度为 n 的数组  Space O(n)
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            List<Integer> row = triangle.get(i);
            // 倒序枚举，最大化利用空间
            dp[i] = dp[i-1] + row.get(i);
            for (int j=i-1; j>0; j--) {
                dp[j] = Math.min(dp[j-1], dp[j]) + row.get(j);
            }
            dp[0] = dp[0] + row.get(0);
        }
        int res = dp[0];
        for (int k=1; k<n; k++) {
            res = Math.min(res, dp[k]);
        }
        return res;
    }

    // 思路同上，每次只需要用到 i 和 i-1 行的数据，所以可以用一个 2*n 的数组来存储，替代 n*n  Space O(2n)
    public static int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++) {
            // 用 % 辅助判断当前行和前一行
            int curr = i % 2;
            int prev = 1 - curr;
            List<Integer> row = triangle.get(i);
            // 动态更新
            dp[curr][0] = dp[prev][0] + row.get(0);
            for (int j=1; j<i; j++) {
                dp[curr][j] = Math.min(dp[prev][j-1], dp[prev][j]) + row.get(j);
            }
            dp[curr][i] = dp[prev][i-1] + row.get(i);
        }
        // 遍历最底层的规划结果，找出最小值
        int[] bottom = dp[(n - 1) % 2];
        int res = bottom[0];
        for (int k=1; k<n; k++) {
            res = Math.min(res, bottom[k]);
        }
        return res;
    }


    public static void main(String[] args) {
        List<Integer> l1 = List.of(2);
        List<Integer> l2 = List.of(3,4);
        List<Integer> l3 = List.of(6,5,9);
        List<Integer> l4 = List.of(4,4,8,0);
        List<List<Integer>> test = List.of(l1,l2,l3,l4);
        System.out.println(minimumTotal(test));
    }

}
