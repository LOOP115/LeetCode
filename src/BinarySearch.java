public class BinarySearch {
//    public static int search(int[] nums, int target) {
//
//        int centerIndex = nums.length/2;
//        int center = nums[centerIndex];
//        if (center == target) {
//            return centerIndex;
//        } else if (target < center) {
//            int[] leftNums = Arrays.copyOfRange(nums, 0, centerIndex);
//            return search(leftNums, target);
//        } else {
//            int[] rightNums = Arrays.copyOfRange(nums, centerIndex+1, nums.length);
//            return search(rightNums, target);
//        }
//
//    }

    public static int search(int[] nums, int target) {
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
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(search(nums, 9));
    }

}
