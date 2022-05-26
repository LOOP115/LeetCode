import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class KWeakestRows {

    // BS + Heap  99.29%
    public static int[] kWeakestRows(int[][] mat, int k) {
        // 构建 PQ
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] pair1, int[] pair2) {
                if (pair1[0] != pair2[0]) {
                    return pair1[0] - pair2[0];
                } else {
                    return pair1[1] - pair2[1];
                }
            }
        });
        // BS + UpHeap
        int m = mat.length;
        for (int i=0; i<m; i++) {
            int ns = numSoldier(mat[i]);
            pq.offer(new int[]{ns, i});
        }
        // Extract first k elements in pq
        int[] ans = new int[k];
        for (int j=0; j<k; j++) {
            ans[j] = Objects.requireNonNull(pq.poll())[1];
        }
        return ans;
    }

    public static int numSoldier(int[] row) {
        int n = row.length;
        int low = 0;
        int high = n - 1;
        if (row[0] == 0) {
            return 0;
        }
        if (row[high] == 1) {
            return n;
        }
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (row[mid] > 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // 官方题解二: BS + 快速选择
    // 在平均 O(m)O(m) 的时间内不计顺序地内找出 kk 个最小的元素，
    // 再使用排序算法在 O(klogk) 的时间对这 k 个最小的元素进行升序排序，就可以得到最终的答案。
    // 读者可以参考「剑指 Offer 40. 最小的k个数」官方题解的方法三或者「215. 数组中的第K个最大元素」的官方题解中的方法一了解快速选择算法
    // 该算法在此题中比 heap 慢，且过于复杂


    public static void main(String[] args) {
        int[][] test = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
        System.out.println(Arrays.toString(kWeakestRows(test, 3)));
    }

}
