import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    // Attempt 1  99.41%
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(ans, t, candidates, target, 0, used);
        return ans;
    }

    public static void backtrack(List<List<Integer>> ans, List<Integer> t, int[] candidates, int target, int cur, boolean[] used) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            // 同 47 判定思路
            // 每次填入的数一定是这个数所在重复数集合中从左往右第一个未被填过的数字
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            t.add(candidates[i]);
            used[i] = true;
            backtrack(ans, t, candidates, target - candidates[i], i + 1, used);
            t.remove(t.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(test, 8));
    }

}
