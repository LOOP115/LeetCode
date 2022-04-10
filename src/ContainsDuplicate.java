import java.util.*;

public class ContainsDuplicate {

    // Attempt 1: Hash Map   49.91%  O(N)
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            int count = map.getOrDefault(i, 0) + 1;
            if (count > 1) {
                return true;
            }
            map.put(i, count);
        }
        return false;
    }

    // Solution 1: Sort and traverse  O(nlogn)
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    // Solution 2: Set  99.08%
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            if (!set.add(x)) {
                return true;
            }
        }
        return false;
    }

    // 评论区一行 stream
    public boolean containsDuplicate3(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }
}
