public class KthMissingPositive {

    // 官方 BS  第 i 个元素为止缺失的元素 pi = ai - i - 1
    // 缺失的第 k 个数 = k - p(i-1) + a(i-1)
    // 找到第一个大于等于 k 的 pi
    // O(logn)  100%
    public static int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        // 此处 high 不能用 length - 1
        // 因为当最后一个元素的缺失个数 < k 时，无法找到一个大于等于 k 的 pi
        // 可以在数组末尾插入一个虚值来解决
        int low = 0;
        int high = arr.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            int x = mid < arr.length ? arr[mid] : Integer.MAX_VALUE;
            if (x - mid - 1 < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return k - (arr[low - 1] - (low - 1) - 1) + arr[low - 1];
    }

    // 评论区解法  O(n)
    // 如果数组中没有小于 k 的数，那么第 k 个缺失的数字就是 k
    // 如果有一个 <= k 的数字，k++
    public int findKthPositive1(int[] arr, int k) {
        for (int j : arr) {
            if (j <= k) k++;
        }
        return k;
    }

    // Attempt1  O(klogn)  k 次 BS
    public static int findKthPositive2(int[] arr, int k) {
        int cnt = 0;
        int i;
        for (i = 1; true; i++) {
            if (!binarySearch(arr, i)) {
                cnt++;
            }
            if (cnt == k) {
                break;
            }
        }
        return i;
    }

    public static boolean binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return arr[low] == x;
    }


    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        System.out.println(findKthPositive(test, 2));
    }

}
