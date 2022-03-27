import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxAreaOfIsland {

    public static int[] dx = {1, 0, 0, -1};
    public static int[] dy = {0, 1, -1, 0};

    // Attempt 1: DFS  24.80%  O(len * wid)
    public static int maxAreaOfIsland(int[][] grid) {
        int len = grid.length, wid = grid[0].length;
        int ans = 0;
        // 存储已访问过的岛屿
        int[][] visited = new int[len][wid];

        for (int i=0; i<len; i++) {
            for (int j=0; j<wid; j++) {
                // 发现新岛屿，进行探索
                int[] loc = new int[]{i, j};
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    AtomicInteger res = new AtomicInteger(0);
                    dfs(grid, len, wid, loc, i, j, res, visited);
                    if (res.get() > ans) {
                        ans = res.get();
                    }
                }
            }
        }
        return ans;
    }

    public static void dfs(int[][] grid, int len, int wid, int[] loc, int x, int y, AtomicInteger area, int[][] visited) {
        if (grid[x][y] == 1) {
            visited[x][y] = 1;
            area.set(area.get() + 1);
            for (int i=0; i<4; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                loc = new int[]{xx, yy};
                if (xx >= 0 && xx < len && yy >= 0 && yy < wid && visited[xx][yy] == 0) {
                    dfs(grid, len, wid, loc, xx, yy, area, visited);
                }
            }
        }
    }

    // Solution 1: DFS  100%
    // 不需要用额外的二维数组来存储已访问过的节点，可以直接将已访问过的节点覆盖为 0
    public static int maxAreaOfIsland1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs1(grid, i, j));
                }
            }
        }
        return max;
    }

    public static int dfs1(int[][] grid, int i, int j) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0){
            return 0;
        }
        int res = 1;
        grid[i][j] = 0;
        res = res + dfs1(grid, i + 1, j) + dfs1(grid, i, j + 1) + dfs1(grid, i - 1, j) + dfs1(grid, i, j - 1);
        return res;
    }

    // Solution 2: DFS using stack  5.69%
    public static int maxAreaOfIsland2(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Deque<Integer> stacki = new LinkedList<>();
                Deque<Integer> stackj = new LinkedList<>();
                stacki.push(i);
                stackj.push(j);
                while (!stacki.isEmpty()) {
                    int cur_i = stacki.pop(), cur_j = stackj.pop();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        stacki.push(next_i);
                        stackj.push(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    // Solution 3: BFS using queue  5.69%
    public static int maxAreaOfIsland3(int[][] grid) {
        int ans = 0;
        for (int i = 0; i != grid.length; ++i) {
            for (int j = 0; j != grid[0].length; ++j) {
                int cur = 0;
                Queue<Integer> queuei = new LinkedList<>();
                Queue<Integer> queuej = new LinkedList<>();
                queuei.offer(i);
                queuej.offer(j);
                while (!queuei.isEmpty()) {
                    int cur_i = queuei.poll(), cur_j = queuej.poll();
                    if (cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1) {
                        continue;
                    }
                    ++cur;
                    grid[cur_i][cur_j] = 0;
                    int[] di = {0, 0, 1, -1};
                    int[] dj = {1, -1, 0, 0};
                    for (int index = 0; index != 4; ++index) {
                        int next_i = cur_i + di[index], next_j = cur_j + dj[index];
                        queuei.offer(next_i);
                        queuej.offer(next_j);
                    }
                }
                ans = Math.max(ans, cur);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland1(grid));
    }

}
