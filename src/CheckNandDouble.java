import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CheckNandDouble {

    // Attempt1  先 sort 数组，再进行 n-1 次 BS
    // O(nlogn + n) = O(nlogn)
    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        if (n == 0) {
            return false;
        }
        int high = n - 1;
        for (int i=0; i<high; i++) {
            int target = arr[i] * 2;
            if (arr[i] < 0) {
                if (arr[i] % 2 != 0) {
                    continue;
                }
                target = arr[i] >> 1;
            }
            if (hasDouble(arr, i+1, high, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDouble(int[] arr, int left, int right, int x) {
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left] == x;
    }

    // 官方题解没有用到 BS
    // Solution1: Sort + 双指针
    // x > 0: 指针一直前进，找到第一个大于 2x 的数字即可停止，说明不存在
    // x < 0: 指针一直后退，找到第一个小于 2x 的数字即可停止，说明不存在
    // O(nlogn + 2n) = O(nlogn)
    // 此题中感觉双指针的做法并不是很 elegant

    // Solution2: Hash  O(n)  99.07%
    public static boolean checkIfExist1(int[] arr) {
        HashSet<Integer> map = new HashSet<>();
        for (int i : arr) {
            if (map.contains(2 * i) || (i % 2 == 0 && map.contains(i >> 1))) {
                return true;
            }
            map.add(i);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] test = {174,380,836,-114,211,-603,8,-787,920,363,-202,-394,32,23,-965,-334,253,785,-177,842,-424,-963,-679,-589,756,-329,661,153,602,-724,-306,-121,-564,-455,381,-803};
        System.out.println(checkIfExist1(test));
    }

}
