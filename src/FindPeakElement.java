public class FindPeakElement {

    // 评论区 爬坡法 100%
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] < nums[mid+1]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    // Attempt 1: BS 100%
    public static int findPeakElement1(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            // mid is peak
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            if (mid > 0) {
                left = nums[mid-1];
            }
            if (mid < len - 1) {
                right = nums[mid+1];
            }
            if (nums[mid] > left && nums[mid] > right) {
                return mid;
            }
            // mid 处于 [low, high], peak 在 mid 右侧
            if (nums[mid] >= nums[low] && nums[mid] <= nums[high]) {
                low = mid + 1;
            }
            // mid 处于 [high, low], peak 在 mid 左侧
            else if (nums[mid] >= nums[high] && nums[mid] <= nums[low]) {
                high = mid - 1;
            }
            // mid > low && mid > high, 往更大一侧搜寻 peak
            else if (nums[mid] > nums[low] && nums[mid] > nums[high]) {
                if (nums[mid + 1] > nums[mid]) {
                    low++;
                } else {
                    high--;
                }
            }
            // mid < low && mid < high, 往更大一侧搜寻 peak
            else if (nums[mid] < nums[low] && nums[mid] < nums[high]) {
                if (nums[low] < nums[high]) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,1,2,3,1};
        int[] test2 = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement1(test1));
    }
}
