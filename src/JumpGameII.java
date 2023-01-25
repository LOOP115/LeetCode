public class JumpGameII {

    // 正向查找可到达的最大位置  98.93%  O(n)
    public static int jump(int[] nums) {
        int n = nums.length - 1;
        int end = 0;
        int rightmost = 0;
        int cnt = 0;
        int cur = 0;
        while (end < n) {
            rightmost = Math.max(rightmost, nums[cur] + cur);
            if (cur == end) {
                end = rightmost;
                cnt++;
            }
            cur++;
        }
        return cnt;
    }


    // 官方: 反向查找出发位置  O(n^2)
    public int jump2(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }


    // Attempt 1
    public static int jump1(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < Math.min(nums[i] + i + 1, n); j++) {
                if (cnt[j] == 0 || cnt[j] > cnt[i] + 1) {
                    cnt[j] = cnt[i] + 1;
                }
            }
        }
        return cnt[n - 1];
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{2,3,1,1,4};
        System.out.println(jump(test1));
    }

}
