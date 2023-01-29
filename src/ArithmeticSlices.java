public class ArithmeticSlices {

    // 官方解法
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            // 快速计算新增的等差数列的数量
            ans += t;
        }
        return ans;
    }


    // Attempt 1: 一次遍历
    public static int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length;
        int res = 0;
        if (n < 3) {
            return res;
        }
        int start = 0;
        int diff = nums[1] - nums[0];
        int postDiff = 0;
        boolean flag = false;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                continue;
            }
            if (nums[i] - nums[i - 1] != diff) {
                res += countSub(i - start);
                start = i;
                diff = nums[i] - nums[i - 1];
                // 避免漏算起始点
                if (i + 1 < n) {
                    postDiff = nums[i + 1] - nums[i];
                    flag = true;
                }
            }
            if (flag && nums[i] - nums[i - 1] == postDiff) {
                start = i - 1;
                diff = postDiff;
                flag = false;
            }
        }
        return res + countSub(n - start);
    }

    public static int countSub(int len) {
        int ans = 0;
        for (int i = 3; i <= len; i++) {
            ans += (len - i) + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 4};
        System.out.println(numberOfArithmeticSlices(test1));
    }

}
