public class SetMatrixZeroes {

    // Attempt 1  思路来源于上一道数独  O(mn)  O(m+n)
    // 和题解 1 思路一样
    public void setZeroes(int[][] matrix) {
        int nRow = matrix.length;
        int nCol = matrix[0].length;
        // 记录哪些行哪些列出现过零
        boolean[] rows = new boolean[nRow];
        boolean[] cols = new boolean[nCol];
        for (int i=0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        // Set zeroes
        for (int i=0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Solution 2  用两个标记 达成 Space O(1)
    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        // Check if the first row has zeroes
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        // Check if the first column has zeroes
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        // 检查别的位置是否有零会导致第一行和第一列中的元素被置零
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 此时第一行和第一列相当于上一个解法中的两个数组，记录了哪些行哪些列出现了零
        // 遍历其他位置 Set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 通过开头的标记判断第一行和第一列是否需要全被置零
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    // Solution 3  只用一个标记实现 Space O(1)
    // 原理是因为可以用 (0,0) 位置的数是否为零来判断第一行是否需要被置零
    // 所以只需要标记第一列是否有没有零
    public void setZeroes2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            // Check if the first column has zeroes
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
            // 第一行第一列记录零出现的位置
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 如果从第一行开始处理，由于第一行先被处理过，新生成的零会影响结果
        // 所以从最后一行反向处理进行置零
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // 当前行除了第一个元素都已处理完，检查是否需要对第一列置零
            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

}
