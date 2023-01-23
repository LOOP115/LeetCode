import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // Solution 1: 利用 bit 枚举  100%
    // Time: O(n * 2^n)
    // Space: O(n)
    public List<List<Integer>> subsets1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 总共有 2^n-1 个子集
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            res.add(temp);
        }
        return res;
    }

    // Solution 2: Recursion  100%
    // Time: O(n * 2^n)
    // Space: O(n)
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        dfsSubset(0, nums, ans, t);
        return ans;
    }

    public static void dfsSubset(int cur, int[] nums, List<List<Integer>> ans, List<Integer> t) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfsSubset(cur + 1, nums, ans, t);
        t.remove(t.size() - 1);
        dfsSubset(cur + 1, nums, ans, t);
    }


    public static void main(String[] args) {
        int[] test = new int[]{1,2,3};
        System.out.println(subsets2(test));
    }

}
