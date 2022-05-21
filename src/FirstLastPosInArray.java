import java.util.Arrays;

public class FirstLastPosInArray {

    // Attempt 1  BS 找到第一个等于 target 的值并向后遍历  100%
    // 缺点是万一有很多值等于 target，需要遍历很多
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int high = nums.length - 1;
        if (high == -1) {
            return res;
        }
        int low = 0;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        // Target found
        if (nums[low] == target) {
            int first = low;
            while ((low + 1 < nums.length) && (nums[low + 1] == target)) {
                low++;
            }
            res[0] = first;
            res[1] = low;
            return res;
        }
        return res;
    }

    // 官方题解，运用两次 BS 分别找到 first 和 last  100%
    // 解决了自己做法可能产生的缺点，但是大多数情况下并不会出现该问题，所以两次 BS 可能反而会更消耗时间
    public int[] searchRange1(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

}
