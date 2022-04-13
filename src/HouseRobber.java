public class HouseRobber {

    // 边界条件：dp[0] = nums[0]  dp[1] = max(nums[0], nums[1])
    // 偷窃第 k 间房屋，那么就不能偷窃第 k−1 间房屋，偷窃总金额为前 k−2 间房屋的最高总金额与第 k 间房屋的金额之和
    // 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额
    // 状态转移方程：dp[k] = max(dp[k-1], dp[k-2] + nums[k])
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int k=2; k<n; k++) {
            dp[k] = Math.max(dp[k-1], dp[k-2] + nums[k]);
        }
        return dp[n-1];
    }


    public static void main(String[] args) {
        int[] test = {2,1,1,2,4};
        System.out.println(rob(test));
    }

}
