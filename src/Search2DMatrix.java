public class Search2DMatrix {

    // Attempt1  100%
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int[] row : matrix) {
            // 当前行中所有数都小于 target, 跳过
            if (row[n - 1] < target) {
                continue;
            }
            // The first row that the row[-1] >= target
            // 找到潜在存在 target 的行
            return binarySearch(row, target);
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low] == target;
    }

    // 官方题解第一种运用了两次 BS，先对矩阵的第一列的元素 BS，找到最后一个不大于目标值的元素，然后在该元素所在行中二分查找目标值是否存在。
    // 第二种则是讲矩阵拼接成一个长数组再进行 BS，感觉都没有自己的做法效率高
}
