import java.util.ArrayList;
import java.util.List;

public class WordSearch {


    // Attempt 1  35.76%  比官方解法快
    // 此题有不讲武德解法，故击败率参考价值较小
    public static int[] dm = new int[]{-1, 1, 0, 0};
    public static int[] dn = new int[]{0, 0, -1, 1};

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        // Find the start position
        char[] wordArray = word.toCharArray();
        char start = wordArray[0];
        int sm;
        int sn;
        List<int[]> starts = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == start) {
                    sm = i;
                    sn = j;
                    starts.add(new int[]{sm, sn});
                }
            }
        }
        if (starts.size() == 0) {
            return false;
        }
        for (int[] pos : starts) {
            boolean[][] visited = new boolean[m][n];
            visited[pos[0]][pos[1]] = true;
            if (wordSearch(board, wordArray, pos[0], pos[1], 0, visited)) {
                return true;
            }
        }
        // Start word search
        return false;
    }

    public static boolean wordSearch(char[][] board, char[] word, int p, int q, int len, boolean[][] visited) {
        if (len == word.length - 1) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int mm = p + dm[i];
            int nn = q + dn[i];
            if (mm < 0 || mm >= board.length || nn < 0 || nn >= board[0].length || board[mm][nn] != word[len + 1] || visited[mm][nn]) {
                continue;
            }
            visited[mm][nn] = true;
            if (wordSearch(board, word, mm, nn, len + 1, visited)) {
                return true;
            } else {
                visited[mm][nn] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] test = new char[][]{{'A','B','C','E'},
                                     {'S','F','E','S'},
                                     {'A','D','E','E'}};
        String word = "ABCESEEEFS";
        System.out.println(exist(test, word));
    }

}
