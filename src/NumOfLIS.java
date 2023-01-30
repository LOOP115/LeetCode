import java.util.ArrayList;
import java.util.List;

public class NumOfLIS {

    // Attempt 1: 基于第 300 题优化  O(n^2) 71.46%
    public static int findNumberOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];
        int maxLen = 1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 叠加之前所有的 valid subsequences
                        cnt[i] += cnt[j];
                    }
                }
            }
            // 更新 ans
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }


    // 官方：贪心 + 前缀和 + 二分查找  99.64%
    public static int findNumberOfLIS(int[] nums) {
        List<List<Integer>> d = new ArrayList<>();
        List<List<Integer>> cnt = new ArrayList<>();
        for (int v : nums) {
            int i = binarySearch1(d.size(), d, v);
            int c = 1;
            if (i > 0) {
                int k = binarySearch2(d.get(i - 1).size(), d.get(i - 1), v);
                c = cnt.get(i - 1).get(cnt.get(i - 1).size() - 1) - cnt.get(i - 1).get(k);
            }
            if (i == d.size()) {
                List<Integer> dList = new ArrayList<>();
                dList.add(v);
                d.add(dList);
                List<Integer> cntList = new ArrayList<>();
                cntList.add(0);
                cntList.add(c);
                cnt.add(cntList);
            } else {
                d.get(i).add(v);
                int cntSize = cnt.get(i).size();
                cnt.get(i).add(cnt.get(i).get(cntSize - 1) + c);
            }
        }

        int size1 = cnt.size(), size2 = cnt.get(size1 - 1).size();
        return cnt.get(size1 - 1).get(size2 - 1);
    }

    public static int binarySearch1(int n, List<List<Integer>> d, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            List<Integer> list = d.get(mid);
            if (list.get(list.size() - 1) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearch2(int n, List<Integer> list, int target) {
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,3,5,4,7};
        System.out.println(findNumberOfLIS(test));
    }

}
