public class LongestIncreasingSubseq {

    // Attempt 1: DP O(n^2)  73.17%
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

    // Greedy + BS  O(nlogn)  99.63%
    public static int lengthOfLIS1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        // d 为无序列表
        // 数组 d[i] 表示长度为 i 的最长上升子序列的末尾元素的最小值
        int[] d = new int[n + 1];
        d[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 在 d 中二分查找，找到第一个比 nums[i] 小的数 d[k]，更新 d[k+1] = nums[i]
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 d[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }


    public static void main(String[] args) {
        int[] test = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS1(test));
    }

}
