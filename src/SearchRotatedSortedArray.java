public class SearchRotatedSortedArray {

    // 官方 BS  O(logn)  100%
    // 将数组一分为二，其中一定有一个是有序的，另一个可能有序，也可能部分有序。
    // 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序，如此循环。
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                // [0, mid] 有序
                if (nums[0] <= target && target < nums[mid]) {
                    // target 处于 [0, mid) 有序范围内，继续二分
                    r = mid - 1;
                } else {
                    // target 不在 [0, mid) 有序范围内，准备拆分另一半数列
                    l = mid + 1;
                }
            } else {
                // [mid, n-1] 有序
                if (nums[mid] < target && target <= nums[n - 1]) {
                    // target 处于 (mid, n-1] 有序范围内，继续二分
                    l = mid + 1;
                } else {
                    // target 不在 (mid, n-1] 有序范围内，准备拆分另一半数列
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] test = {4,5,6,7,8,1,2,3};
        System.out.println(search(test, 8));
    }

}
