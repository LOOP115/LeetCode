import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {

    // Solution 1: DFS  99.88%  O(nm)
    public static int n, m;

    public static void solveDFS(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }


    // Solution 2: BFS  不用额外维持 visited 数组  直接更改标记   45.96%
    public static int[] dm = new int[]{-1, 1, 0, 0};
    public static int[] dn = new int[]{0, 0, -1, 1};

    public static void solveBFS(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][m - 1] == 'O') {
                queue.offer(new int[]{i, m - 1});
                board[i][m - 1] = 'A';
            }
        }
        for (int i = 1; i < m - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[n - 1][i] == 'O') {
                queue.offer(new int[]{n - 1, i});
                board[n - 1][i] = 'A';
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + dm[i], my = y + dn[i];
                if (mx < 0 || my < 0 || mx >= n || my >= m || board[mx][my] != 'O') {
                    continue;
                }
                queue.offer(new int[]{mx, my});
                board[mx][my] = 'A';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }


    // Attempt 1  多源 BFS  22.11%
    public static void solveBFS1(char[][] board) {
        int m = board.length;
        int n = board[0]. length;
        Queue<int[]> queue = new LinkedList<>();
        // Find 'O' on borders
        for (int col = 0; col < n; col++) {
            if (board[0][col] == 'O') {
                queue.offer(new int[]{0, col});
            }
            if (board[m - 1][col] == 'O') {
                queue.offer(new int[]{m - 1, col});
            }
        }
        for (int row = 1; row < m - 1; row++) {
            if (board[row][0] == 'O') {
                queue.offer(new int[]{row, 0});
            }
            if (board[row][n - 1] == 'O') {
                queue.offer((new int[]{row, n - 1}));
            }
        }

        int[][] visited = new int[m][n];
        // Start BFS
        while (!queue.isEmpty()) {
            int[] loc = queue.poll();
            visited[loc[0]][loc[1]] = 1;
            for (int i = 0; i < 4; i++) {
                int mm = loc[0] + dm[i];
                int nn = loc[1] + dn[i];
                if (mm < 0 || mm >= m || nn < 0 || nn >= n || board[mm][nn] != 'O' || visited[mm][nn] == 1) {
                    continue;
                }
                queue.offer(new int[]{mm, nn});
            }
        }

        // Flip
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O' && visited[row][col] != 1) {
                    board[row][col] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'X', 'X', 'X', 'X'},
                                     {'X', 'O', 'O', 'X'},
                                     {'X', 'X', 'O', 'X'},
                                     {'X', 'O', 'X', 'X'}};
        solveBFS1(test);
        System.out.println(0);
    }

}
