import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectTwoArraysII {

    // Sort + 双指针 89.79%  O(mlogm+nlogn)
    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int p1 = 0, p2 = 0;
        int[] tempAns = n1 < n2 ? new int[n1] : new int[n2];
        int count = 0;

        while (p1 < n1 && p2 < n2) {
            if (nums1[p1] < nums2[p2]) {
                p1++;
            } else if (nums1[p1] > nums2[p2]) {
                p2++;
            } else if (nums1[p1] == nums2[p2]) {
                tempAns[count] = nums1[p1];
                count++;
                p1++;
                p2++;
            }
        }

        if (count == tempAns.length) {
            return tempAns;
        }

        int[] ans = new int[count];
        System.arraycopy(tempAns, 0, ans, 0, count);
        return ans;
    }

    // HashMap 官方 89.79%  O(m+n)
    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 对较短的数组构建哈希表
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                ans[index++] = num;
                count--;
                if (count > 0) {
                    // 哈希表里对应数值-1
                    map.put(num, count);
                } else {
                    // 将该数移除哈希表
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

}
