import java.util.Arrays;

public class MinSizeSubarraySum {

    // Sliding window  O(n)  100%
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // Solution 2: Prefix Sum + BS  O(nlogn)
    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n + 1];
        // 为了方便计算，令 size = n + 1
        // sums[0] = 0 意味着前 0 个元素的前缀和为 0
        // sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
        // 以此类推
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            // 由于前缀和累加，目标和需要加上之前额外的部分
            int s = target + sums[i - 1];
            int bound = Arrays.binarySearch(sums, s);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= n) {
                ans = Math.min(ans, bound - (i - 1));
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = new int[]{2,3,1,2,4,3};
        int target2 = 11;
        int[] nums2 = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen1(target1, nums1));
    }

}
