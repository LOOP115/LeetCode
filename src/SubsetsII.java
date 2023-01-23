import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    // Solution 1: Bit 枚举  99.54%
    // 对于当前选择的数 x，若前面有与其相同的数 y，且没有选择y，
    // 此时包含 x 的子集，必然会出现在包含 y 的所有子集中。
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int mask = 0; mask < (1 << n); mask++) {
            boolean flag = true;
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && nums[i] == nums[i - 1] && (mask & (1 << (i - 1))) == 0) {
                        flag = false;
                        break;
                    }
                    t.add(nums[i]);
                }
            }
            if (flag) {
                ans.add(t);
            }
        }
        return ans;
    }


    // Solution 2: Backtracking  99.54%
    // 在递归时，若发现没有选择上一个数，且当前数字与上一个数相同，则可以跳过当前生成的子集。
    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        Arrays.sort(nums);
        dfsSubsetII(0, nums, ans, t, false);
        return ans;
    }

    public static void dfsSubsetII(int cur, int[] nums, List<List<Integer>> ans, List<Integer> t, boolean choosePre) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        dfsSubsetII(cur + 1, nums, ans, t, false);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        t.add(nums[cur]);
        dfsSubsetII(cur + 1, nums, ans, t, true);
        t.remove(t.size() - 1);
    }

    // Backtracking
    // 此版本便于理解
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);      // 排序后便于去重
        dfs(res, new ArrayList<>(), 0, nums.length, nums);
        return res;
    }
    // dfs - 递归函数
    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int len, int[] nums){
        if(index == len){   // [基本情况] 如果游标到达尾部，将当前list拷贝放入res中
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(res, list, index + 1, len, nums); // 选择当前的数
        list.remove(list.size() - 1);   // 回溯 - 将当前添加的数删除
        while (index < len - 1 && nums[index] == nums[index + 1]){ // 去重，不选当前数递归时直接跳过重复数
            index++;    // 所有重复数的可能性在前面递归中均会出现
        }
        dfs(res, list, index + 1, len, nums); // 不选择当前的数
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,2};
        System.out.println(subsetsWithDup2(test));
    }

}
