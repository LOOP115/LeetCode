import java.util.Arrays;

public class SquaresSortedArray {
    public static int[] sortedSquares1(int[] nums) {
        for (int i = 0; i<nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortedSquares2(int[] nums) {
        // Find the index which numbers become positive
        int n = nums.length;
        int neg = -1;
        for (int i=0; i < n; i++) {
            if (nums[i] > 0) {
                break;
            } else {
                neg = i;
            }
        }

        // Formulate the answer array
        int[] ans = new int[n];
        int i = 0, j = neg, k = neg + 1;
        while (k < n || j >= 0) {
            if (j < 0) {
                // Case 1: No negative numbers in array
                ans[i] = nums[k] * nums[k];
                k++;
            }else if (k == n) {
                // Case 2: All numbers are negative
                ans[i] = nums[j] * nums[j];
                j--;
            } else if (nums[j] * nums[j] > nums[k] * nums[k]) {
                // Case 3: Has both positive and negative
                // Merge two parts
                ans[i] = nums[k] * nums[k];
                k++;
            } else {
                ans[i] = nums[j] * nums[j];
                j--;
            }
            i++;
        }
        return ans;
    }

    // Compare head and tail
    // Insert in reverse order
    public static int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int i = n - 1, j = 0, k = n - 1;
        while (j<=k) {
            if (nums[j] * nums[j] > nums[k] * nums[k]) {
                ans[i] = nums[j] * nums[j];
                j++;
            } else {
                ans[i] = nums[k] * nums[k];
                k--;
            }
            i--;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {-7,-3,2,3,11};
        int[] nums2 = {-7,-3,2,3,11};
        int[] nums3 = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares1(nums1)));
        System.out.println(Arrays.toString(sortedSquares2(nums2)));
        System.out.println(Arrays.toString(sortedSquares3(nums3)));

    }
}
