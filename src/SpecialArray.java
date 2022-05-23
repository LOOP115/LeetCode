import java.util.Arrays;

public class SpecialArray {

    // Attempt1  多次 BS  79.46%
    public static int specialArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i=0; i < Integer.MAX_VALUE; i++) {
            // Can not be special
            if (i > n) {
                break;
            }
            // 第一个 >= i 的数
            int pos = binarySearch(nums, i);
            if (n - pos == i) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (low == arr.length - 1 && arr[low] < x) {
            return arr.length;
        }
        return low;
    }

    // 一次 BS  79.46%  O(logn)
    public static int specialArray1(int[] nums) {
        int left = 0, right = nums.length - 1;
        Arrays.sort(nums);
        while (left <= right) {
            int mid = (right + left) >>> 1;
            int specialNum = nums.length - mid;
            if (nums[mid] < specialNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if (mid == 0 || nums[mid - 1] < specialNum) {
                    return specialNum;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {3};
        System.out.println(specialArray1(arr));
    }

}
