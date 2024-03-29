import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    // 上下左右
    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    // Solution 1：BFS，把所有 0 看成一个整体  O(rc)
    public static int[][] updateMatrix1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 将所有的 0 添加进初始队列中，构建超级源点
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }

    // Solution 2：动态规划  98.95%  O(rc)  Space: O(1)
    // 从最近的0走到1，肯定只能从1周围上下左右4个点走到1，第一次从左上角到右下角遍历整个表，
    // 到表中任意位置i的时候，i上方和左方的位置已经遍历过了，所以可以判断从上方进入这个1和左方进入这个1的状况哪个最近，并在dp数组保存。
    // 同理，第二次从右下角到左上角遍历整个表到i位置时，i右方和下方的位置状态已经更新过了，所以能判断从右边进入合算还是从下边进入合算，
    // 再加上第一次遍历保存的左方和上方的最优解就能判断出上下左右四个方向的最优解了
    // 所以只用选择两组对应相反方向
    public static int[][] updateMatrix2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化动态规划的数组，所有的距离值都设置为一个很大的数
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
        }
        // 如果 (i, j) 的元素为 0，那么距离为 0
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        // 只有 水平向左移动 和 竖直向上移动，注意动态规划的计算顺序
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }
//        // 只有 水平向左移动 和 竖直向下移动，注意动态规划的计算顺序
//        for (int i = m - 1; i >= 0; --i) {
//            for (int j = 0; j < n; ++j) {
//                if (i + 1 < m) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
//                }
//                if (j - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
//                }
//            }
//        }
//        // 只有 水平向右移动 和 竖直向上移动，注意动态规划的计算顺序
//        for (int i = 0; i < m; ++i) {
//            for (int j = n - 1; j >= 0; --j) {
//                if (i - 1 >= 0) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
//                }
//                if (j + 1 < n) {
//                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
//                }
//            }
//        }
        // 只有 水平向右移动 和 竖直向下移动，注意动态规划的计算顺序
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i + 1 < m) {
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
        }
        return dist;
    }


    public static void main(String[] args) {
        int[][] mat = {{0,1,0},{0,1,0},{1,1,1}};
        int[][] ans = updateMatrix2(mat);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

}
