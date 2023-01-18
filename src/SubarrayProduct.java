public class SubarrayProduct {

    // Sliding window  O(n)  100%
    // 固定右端
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            // 以右端点元素为末尾元素的子数组的个数(区间多长，含末尾元素的子数组就有多少个)，
            // 所有元素做队尾的子数组数之和就是符合条件子数组的个数。
            // 比如例子[10,5,2,6]以10做队尾的子数组[10],以5做队尾的子数组[10,5],[5]，以2作队尾 [5,2],[2],以此类推。
            ret += j - i + 1;
        }
        return ret;
    }

    // Binary Search  O(nlogn)
    public static int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }
        int n = nums.length;
        double[] logPrefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            logPrefix[i + 1] = logPrefix[i] + Math.log(nums[i]);
        }
        double logk = Math.log(k);
        int ret = 0;
        for (int j = 0; j < n; j++) {
            int l = 0;
            int r = j + 1;
            int idx = j + 1;
            double val = logPrefix[j + 1] - logk + 1e-10;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (logPrefix[mid] > val) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ret += j + 1 - idx;
        }
        return ret;
    }

    // Brute
    public static int numSubarrayProductLessThanK0(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                continue;
            }
            res++;
            int product = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] * product < k) {
                    res++;
                    product *= nums[j];
                } else {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 5, 2, 6};
        int k1 = 100;
        int[] nums2 = new int[]{1, 2, 3};
        int k2 = 0;
        System.out.println(numSubarrayProductLessThanK(nums1, k1));
    }

}
