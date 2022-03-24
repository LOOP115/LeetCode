import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectTwoArrays {

    // Set 93.84%
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] ans = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            ans[i++] = num;
        }
        return ans;
    }

    // Sort + 双指针 93.84%
    public static int[] intersection2(int[] nums1, int[] nums2) {
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
                if (p1 == 0 || p2 == 0 || (nums1[p1-1] != nums1[p1] && nums2[p2-1] != nums2[p2])) {
                    tempAns[count] = nums1[p1];
                    count++;
                }
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


    // 评论区用stream实现的极简代码，实际速度好像并不快，只击败了 6.89%
    public int[] intersectionStream(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

}
