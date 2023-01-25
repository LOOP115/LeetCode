public class JumpGame {

    // 改良版 不需要维持数组  94.10
    public static boolean canJump(int[] nums) {
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > k) return false;
            // 可以提前结束循环，但加了下面一行击败率会下降
            // if (i > n - 1) return true;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }


    // Attempt 1  记录每个位置所能跳到的最高位置
    public static boolean canJump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (dp[i - 1] < i) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] test1 = new int[]{2,3,1,1,4};
        int[] test2 = new int[]{3,2,1,0,4};
        System.out.println(canJump(test2));
    }

}
