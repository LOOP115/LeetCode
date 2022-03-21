public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // Search left portion
                high = mid - 1;
            } else {
                // Search right portion
                low = mid + 1;
            }
        }
        // Insert position
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums, 7));
    }

}
