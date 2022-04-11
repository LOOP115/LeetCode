import java.util.Arrays;

public class MergeSortedArray {

    // Solution 1  O((m+n)log(m+n))
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    // Solution 2  O(m+n)
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int cur;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                cur = nums2[p2++];
            } else if (p2 == n) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = cur;
        }
        System.arraycopy(sorted, 0, nums1, 0, m+n);
    }

    // Solution 3  逆向双指针，利用后部空间  100%
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        m--;
        n--;
        for (int i=len; i>=0; i--) {
            if (m == -1) {
                nums1[i] = nums2[n--];
            } else if (n == -1) {
                nums1[i] = nums1[m--];
            } else if (nums1[m] > nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0};
        int m = 5;
        int[] nums2 = {3};
        int n = 1;
        merge3(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
