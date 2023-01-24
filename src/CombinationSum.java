import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    // Attempt 1  100%
    // Time: O(S)  S = len(所有可能解)
    // Space: O(target)
    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        backtrack(candidates, target, ans, t, 0);
        return ans;
    }

    public static void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> t, int cur) {
        if (target == 0) {
            ans.add(new ArrayList<>(t));
        }
        if (target < 0) {
            return;
        }
        for (int i = cur; i < candidates.length; i++) {
            // 剪枝
            if (target < candidates[i]) {
                return;
            }
            t.add(candidates[i]);
            backtrack(candidates, target - candidates[i], ans, t, i);
            t.remove(t.size() - 1);
        }
    }

    // 官方解法  100%
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] test = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum1(test, 7));
    }

}
