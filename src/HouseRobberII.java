public class HouseRobberII {

    // 比较不偷第一间和不偷最后一间的结果  100%  O(n)
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (n == 3) {
            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        return Math.max(robDp(0, nums, n - 1), robDp(1, nums, n - 1));
    }

    public static int robDp(int start, int[] nums, int len) {
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, 7, 9, 2};
        System.out.println(rob(test));
    }

}
