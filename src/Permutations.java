import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {

    // Backtracking  O(n*n!)
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int n: nums) {
            temp.add(n);
        }
        int len = nums.length;
        backtrack(len, 0, temp, ans);
        return ans;
    }

    public static void backtrack(int len, int first, List<Integer> temp, List<List<Integer>> ans) {
        // 填完了，加入 ans
        if (first == len) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i=first; i<len; i++) {
            // 以不同数字开头进行排列
            Collections.swap(temp, first, i);
            // 递归
            backtrack(len, first + 1, temp, ans);
            // 撤销之前的交换操作，动态维护数组
            Collections.swap(temp, first, i);
        }
    }

    // 评论区 100%, 大体思路一样  用了一个 boolean 数组来记录每个数组是否被使用过的状态
    public List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute1(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(n);
        boolean[] used = new boolean[n];
        int count = 0;
        backtrace(list, used, count, nums);
        return lists;
    }

    public void backtrace(List<Integer> list, boolean[] used, int count, int[] nums) {
        if (count == nums.length) {
            lists.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backtrace(list, used, count + 1, nums);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

}
