import java.util.Arrays;

public class FindTheDistValue {

    // 二分查找  O((m+n)logm)  91.78%
    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n2 = arr2.length;
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            // 分别比较离 x 最近的两个数
            int i = binarySearch(arr2, x);
            if (arr2[i] <= x) {
                // 所有数都 < x
                if (x - arr2[i] > d) {
                    cnt++;
                    continue;
                }
            }
            // 第一个 >= x 的数
            if (arr2[i] - x <= d) {
                continue;
            }
            // 最大的 < x 的数
            if (i - 1 >= 0) {
                if (x - arr2[i - 1] <= d) {
                    continue;
                }
            }
            // 符合规则
            cnt++;
        }
        return cnt;
    }

    // 找到第一个大于等于 x 的 index
    public static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (high + low) >>> 1;
            if (x > arr[mid]) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    // 官方二分查找  51.13%
    public int findTheDistanceValue1(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    // 官方 brute
    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int x : arr1) {
            boolean ok = true;
            for (int y : arr2) {
                ok &= Math.abs(x - y) > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }


    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8};
        int[] arr2 = {1, 8, 9, 10};
        System.out.println(binarySearch(arr2, 11));
        System.out.println(findTheDistanceValue(arr1, arr2, 2));
    }

}
