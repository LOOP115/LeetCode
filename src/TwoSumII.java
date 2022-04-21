import java.util.Arrays;

public class TwoSumII {

    // Brute force
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    ans = new int[]{i+1, j+1};
                    break;
                }
            }
        }
        return ans;
    }

    // Binary Search
    public static int[] twoSum1(int[] numbers, int target) {
        int n = numbers.length;
        // Traverse the array
        for (int i=0; i<n; i++) {
            int low = i + 1, high = n - 1;
            int diff = target - numbers[i];
            // Using binary search to match the difference of target and current number
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == diff) {
                    return new int[]{i+1, mid+1};
                }
                // Search right portion
                if (diff > numbers[mid]) {
                    low = mid + 1;
                } else {
                    // Search left portion
                    high = mid - 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Two pointers
    public static int[] twoSum2(int[] numbers, int target) {
        int n = numbers.length;
        int head = 0, tail = n - 1;
        while (numbers[head] + numbers[tail] != target) {
            // Sum > target, move tail pointer left
            if (numbers[head] + numbers[tail] > target) {
                tail--;
            } else {
                // Sum < target, move head pointer right
                head++;
            }
        }
        return new int[]{head+1, tail+1};
    }

    // Combine binary search and double pointers
    public static int[] twoSum3(int[] numbers, int target) {
        int n = numbers.length;
        int head = 0, tail = n - 1;
        while (head < tail) {
            int mid = (head + tail) >>> 1;
            if (numbers[head] + numbers[mid] > target) {
                // Abandon right portion
                tail = mid - 1;
            } else if (numbers[tail] + numbers[mid] < target) {
                // Abandon left portion
                head= mid + 1;
            } else if (numbers[head] + numbers[tail] > target) {
                // Head + Tail > target, move tail pointer left
                tail--;
            } else if (numbers[head] + numbers[tail] < target){
                // Head + Tail < target, move head pointer right
                head++;
            } else {
                return new int[]{head+1, tail+1};
            }
        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        int[] nums = {12,83,104,129,140,184,199,300,306,312,321,325,341,344,349,356,370,405,423,444,446,465,471,491,500,506,508,530,539,543,569,591,606,607,612,614,623,627,645,662,670,685,689,726,731,737,744,747,764,773,778,787,802,805,811,819,829,841,879,905,918,918,929,955,997};
        int target = 789;
        System.out.println(Arrays.toString(twoSum3(nums, target)));
    }

}
