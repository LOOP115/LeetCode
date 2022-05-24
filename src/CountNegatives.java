public class CountNegatives {

    // Attempt1  m 次 BS  O(mlogn)  100%
    public static int countNegatives(int[][] grid) {
        int cnt = 0;
        for (int[] arr : grid) {
            int n = arr.length;
            int i = binarySearch(arr);
            cnt += n - i;
        }
        return cnt;
    }

    public static int binarySearch(int[] row) {
        int left = 0;
        int right = row.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (row[mid] < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == row.length - 1) {
            if (row[left] >= 0) {
                return row.length;
            }
        }
        return left;
    }

    // 评论区 倒序遍历，利用每行每列均非递增  100%
    // [ 4, 3, 2,-1]
    // [ 3, 2, 1,-1]
    // [ 1, 1,-1,-2]
    // [-1,-1,-2,-3]
    // 从右上角开始遍历，i = 0, j = grid[0].length - 1
    // 如果当前值大于等于 0，那么前面的值肯定都非负，那么直接跳过，进入下一行, 即 i++
    // 如果当前值小于 0，那么当前值以及同列下的值都是小于 0 的，那么直接添加，然后进行下一列，即 j--
    public static int countNegatives1(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int count = 0;
        for(int i = 0, j = grid[0].length - 1; i < grid.length && j >= 0; ){
            if(grid[i][j] >= 0){
                i++;
            }else{
                count += grid.length - i;
                j--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,1,2};
        System.out.println(binarySearch(arr));
    }

}
