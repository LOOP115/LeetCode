import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    // DFS 100%
    public static int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m == 0) {
            return res;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // New Island found, Start DFS
                    res++;
                    dfsIsland(grid, m, n, i, j);
                }
            }
        }
        return res;
    }

    public static void dfsIsland(char[][] grid, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfsIsland(grid, m, n, i - 1, j);
        dfsIsland(grid, m, n, i + 1, j);
        dfsIsland(grid, m, n, i, j - 1);
        dfsIsland(grid, m, n, i, j + 1);
    }


    // Attempt 1: BFS 34.67%
    public static int numIslands1(char[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m == 0) {
            return res;
        }
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // New Island found, Start BFS
                    bfsIsland(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public static void bfsIsland(char[][] grid, int m, int n, int i, int j) {
        int[] dm = new int[]{-1, 1, 0, 0};
        int[] dn = new int[]{0, 0, -1, 1};
        Queue<int[]> explore = new LinkedList<>();
        explore.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!explore.isEmpty()) {
            // Set explored nodes to 0 and check its neighbours
            int[] loc = explore.poll();
            for (int k = 0; k < 4; k++) {
                int ii = loc[0] + dm[k];
                int jj = loc[1] + dn[k];
                // Check if in bound
                if (ii >= 0 && ii < m && jj >=0 && jj < n) {
                    if (grid[ii][jj] == '1') {
                        explore.offer(new int[]{ii, jj});
                        // 注意在什么位置修改标记
                        // 错误位置会导致超时，因为会有产生很多重复坐标
                        grid[ii][jj] = '0';
                    }
                }
            }
        }
    }


    // 并查集  62.05%
    public static int find(int i, int[] p){
        if (p[i] == i) return p[i];
        return p[i] = find(p[i], p);
    }

    public static boolean union(int i, int j, int[] p){
        if (find(i, p) == find(j, p)) return false; //避免重复合并操作
        p[find(i, p)] = p[find(j, p)];
        return true;
    }

    public static int numIslands2(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] p = new int[m * n];
        int res = 0;

        //初始化 parent 数组，记录初始岛屿数（也就是 1 的数目）
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int idx = i * n + j;
                p[idx] = idx;
                if(grid[i][j] == '1')
                    res++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (grid[i][j] == '1') {
                    if (i+1 < m && grid[i+1][j] == '1') { //合并岛屿
                        if (union(idx, (i + 1) * n + j, p)) res--;
                    }
                    if (j+1 <n && grid[i][j+1] == '1') {
                        if (union(idx, i * n + j + 1, p)) res--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'1', '1', '1', '1', '0'},
                                     {'1', '1', '0', '1', '0'},
                                     {'1', '1', '0', '0', '0'},
                                     {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(test));
    }

}
