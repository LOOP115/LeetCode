import java.util.Arrays;

public class ReshapeMatrix {

    // Attempt 1  100%
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // 原矩阵格式
        int or = mat.length;
        int oc = mat[0].length;
        if (or * oc != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int rr = 0;
        int cc = 0;

        for (int[] row : mat) {
            for (int i = 0; i < oc; i++) {
                res[rr][cc] = row[i];

                if (cc == c - 1) {
                    // 当前行填满，开始填下一行
                    rr++;
                    cc = 0;
                } else {
                    // 继续填充当前行
                    cc++;
                }
            }
        }
        return res;
    }

    // Solution  二维数组的一维表示  flatten
    // (i,j) => i * n + j  n: # of columns
    // i = x / n  j = x % n
    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        int or = mat.length;
        int oc = mat[0].length;
        if (or * oc != r * c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int x=0; x<r*c; x++) {
            res[x / c][x % c] = mat[x / oc][x % oc];
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] mat = {{1,2},{3,4},{5,6},{7,8}};
        int r = 2;
        int c = 4;
        int[][] res = matrixReshape2(mat, r, c);
        for (int[] row: res) {
            System.out.println(Arrays.toString(row));
        }
    }

}
