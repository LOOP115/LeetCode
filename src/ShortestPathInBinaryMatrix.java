import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    public static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    // Attempt 1: BFS  61.21%
    public static int shortestPathBinaryMatrixBFS(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        int[][] costs = new int[n][n];
        for (int[] row: costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        costs[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        // Push start point
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            int tempCost = costs[loc[0]][loc[1]];
            // Find neighbours
            for (int i = 0; i < 8; i++) {
                int p = loc[0] + dx[i];
                int q = loc[1] + dy[i];
                // Check in bound
                if (p >= 0 && p < n && q >= 0 && q < n) {
                    if (grid[p][q] == 0 && costs[p][q] > tempCost + 1) {
                        costs[p][q] = tempCost + 1;
                        queue.offer(new int[]{p, q});
                    }
                }
            }
        }
        return costs[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : costs[n-1][n-1];
    }


    // Attempt 2 DFS 超时
    public static int shortestPathBinaryMatrixDFS(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        int[][] costs = new int[n][n];
        for (int[] row: costs) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dfsShortestPathBinaryMatrix(grid, costs, 0, 0, n, 0);
        return costs[n - 1][n - 1] == Integer.MAX_VALUE ? -1 : costs[n-1][n-1];
    }


    public static void dfsShortestPathBinaryMatrix(int[][] grid, int[][] costs, int p, int q, int n, int cost) {
        if (p < 0 || p >= n || q < 0 || q >= n || grid[p][q] != 0 || cost + 1 >= costs[p][q]) {
            return;
        }
        costs[p][q] = cost + 1;
        for (int i = 0; i < 8; i++) {
            dfsShortestPathBinaryMatrix(grid, costs, p + dx[i], q + dy[i], n, cost + 1);
        }
    }


    public static void main(String[] args) {
        int[][] test1 = new int[][]{{0,0,0},{1,1,0},{1,1,0}};
        int[][] test2 = new int[][]{{1,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrixBFS(test1));
        System.out.println(shortestPathBinaryMatrixDFS(test2));
    }

}
