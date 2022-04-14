public class ValidSudoku {

    // 数独可以用一次遍历完成  99.68%
    public boolean isValidSudoku(char[][] board) {
        // 记录 rows 中数字的出现次数
        int[][] rows = new int[9][9];
        // 记录 columns
        int[][] cols = new int[9][9];
        // 记录 sub-boxes
        int[][][] subs = new int[3][3][9];
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '1';
                    // 数独的第 i 行出现 c 的次数 + 1
                    rows[i][index]++;
                    // 数独的第 j 列出现 c 的次数 + 1
                    cols[j][index]++;
                    // 当前九宫格出现 c 的次数 + 1
                    subs[i/3][j/3][index]++;
                    if (rows[i][index] > 1 || cols[j][index] > 1 || subs[i/3][j/3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
