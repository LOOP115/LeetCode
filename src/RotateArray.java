import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[n-k];
        System.arraycopy(nums, 0, temp, 0, n-k);

        int pos = 0, j = 0;
        while (pos < n) {
            if (pos < k) {
                nums[pos] = nums[pos + n - k];
            } else {
                nums[pos] = temp[j];
                j++;
            }
            pos++;
        }
    }

    // Extra array
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    // 环状替换
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        // 为访问到所有元素，需要遍历的次数
        int count = gcd(n, k);
        for (int init=0; init<count; init++) {
            int curr = init;
            int prev = nums[init];
            // 循环交换
            do {
                // New index for current number
                int next = (curr + k) % n;
                // Store the original number on the new index
                int temp = nums[next];
                // Assign current number to new position
                nums[next] = prev;
                // Update states
                prev = temp;
                curr = next;
            } while (init != curr);
        }
    }

    // 最大公约数
    public static int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }

    // 数组翻转
    public static void rotate3(int[] nums, int k) {
        int n = nums.length - 1;
        k %= n + 1;
        // Reverse whole
        reverse(nums, 0, n);
        // Reverse nums[0:k]
        reverse(nums, 0, k - 1);
        // Reverse nums[k+1:]
        reverse(nums, k, n);
    }

    // Reverse an array from given start and end indexes
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] nums1 = {1};
        rotate3(nums1, 2);
        System.out.println(gcd(6, 2));
        System.out.println(Arrays.toString(nums1));
    }

}
