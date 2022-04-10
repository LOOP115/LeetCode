import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // Attempt1  HashMap  73.82%
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            int value = map.getOrDefault(diff, -1);
            if (value >= 0) {
                return new int[]{value, i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    // 官方哈希表，思路其实差不多  99.38%
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] test = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(test, target)));
    }

}
