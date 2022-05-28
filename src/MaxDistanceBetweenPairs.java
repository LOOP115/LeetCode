public class MaxDistanceBetweenPairs {

    // 双指针 O(n1 + n2)  95.10%
    public static int maxDistance(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int L = 0;
        int R = 0;
        while (L < len1 && R < len2) {
            if (nums1[L] > nums2[R]) {
                L++;
            }
            R++;
        }
        return Math.max(R - L - 1, 0);
    }

    // Attempt1: 多次 BS  O(n1logn2)  32.14%
    public static int maxDistance1(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int dist = 0;
        if (n1 == 0 || n2 == 0) {
            return dist;
        }
        for (int i=0; i<n1; i++) {
            // Index of first number in nums2 < arr[i]
            int pos = binarySearch(nums2, nums1[i]);
            if (pos >= i) {
                // Get Max distance for arr[i]
                dist = Math.max(dist, pos - i);
            }
        }
        return dist;
    }

    // 找到第一个 < x 的数
    public static int binarySearch(int[] arr, int x) {
        int len = arr.length;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] >= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // 全 >= x
        if (arr[low] >= x) {
            return low;
        }
        return low - 1;
    }


    public static void main(String[] args) {
        int[] nums1 = {55,30,5,4,2};
        int[] nums2 = {100,20,10,10,5};
        System.out.println(maxDistance1(nums1, nums2));
    }

}
