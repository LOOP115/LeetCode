import java.util.Arrays;

public class MoveZeros {

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n-1; i++) {
            // 遇到0，需要往后调换
            if (nums[i] == 0) {
                int pos = i;
                for (int j=1; j<n-i; j++) {
                    // 遇到0则跳过
                    if (nums[i+j] != 0) {
                        nums[pos] = nums[i+j];
                        nums[i+j] = 0;
                        pos++;
                    }
                }
            }
        }
    }

    // 官方双指针，实际运行速度没有很快
    public static void moveZeroes1(int[] nums) {
        int n = nums.length;
        // 左指针左侧均为非零数，右指针到左指针均为零
        int left = 0, right = 0;
        while (right < n) {
            // 遇到零则移动右指针
            // 非零则交换右指针和左指针的数并移动左指针
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public static void swap (int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // 评论区 100% 方法
    public static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        // index 记录更新非零数的个数
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // 将非零数移到数组前端
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 从 index 位置起全为零
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {0,0,1};
        int[] nums2 = {0,1,0,3,12};
        moveZeroes1(nums1);
        System.out.println(Arrays.toString(nums1));
    }

}
