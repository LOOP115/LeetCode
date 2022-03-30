import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

    public static int[] dx = new int[]{1, 0, 0, -1};
    public static int[] dy = new int[]{0, 1, -1, 0};

    // 多源 BFS，解题时主要问题在如何记录腐烂时间，官方用的是 HashMap
    public static int orangesRotting(int[][] grid) {
        int fresh = 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // 记录 fresh oranges 的数量，将所有 rotten oranges 添加进初始队列中，构建超级源点
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minute = 0;
        // 没有好橘子
        if (fresh == 0) {
            return minute;
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 当前所有烂橘子向外腐烂
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int d = 0; d < 4; d++) {
                    int xx = x + dx[d];
                    int yy = y + dy[d];
                    if (xx >= 0 && xx < m && yy >= 0 && yy < n && grid[xx][yy] == 1) {
                        // Fresh orange become rotting
                        fresh--;
                        grid[xx][yy] = 2;
                        queue.add(new int[]{xx, yy});
                    }
                }
            }
            minute++;
        }
        // 队列中最后一层烂橘子遍历后时间会加一，但是没有新的橘子腐烂了
        return fresh == 0 ? minute - 1 : -1;
    }


    public static void main(String[] args) {
        int[][] grid1 = {{2,1,1},{1,1,1},{0,1,2}};
        int[][] grid2 = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid1));
    }

}
