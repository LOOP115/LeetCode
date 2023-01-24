import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    // Backtracking 99.77%
    public static List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(nums, ans, t, 0, used);
        return ans;
    }

    public static void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> t, int cnt, boolean[] used) {
        if (cnt == nums.length) {
            ans.add(new ArrayList<>(t));
        }
        for (int i = 0; i < nums.length; i++) {
            // 每次填入的数一定是这个数所在重复数集合中
            // 从左往右第一个未被填过的数字
            if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) {
                continue;
            }
            t.add(nums[i]);
            used[i] = true;
            backtrack(nums, ans, t, cnt + 1, used);
            t.remove(t.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(permuteUnique(nums));
    }

}
