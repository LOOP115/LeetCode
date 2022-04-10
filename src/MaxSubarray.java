public class MaxSubarray {

    // Attempt 1  贪心法思想  100%  O(n)
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;
        while (i < nums.length) {
            int temp = sum + nums[i];
            if (temp > max) {
                max = temp;
            }
            // 之前和 < 0 就重新开始
            sum = Math.max(temp, 0);
            i++;
        }
        return max;
    }

    // Solution 1  动态规划  O(n)  100%
    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    // Solution 2  分治-线段树  O(logn)  实际在此题中很慢
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length <= 0)// 输入校验
            return 0;
        int len = nums.length;// 获取输入长度
        return getInfo(nums, 0, len - 1).mSum;
    }

    public static class wtevTree { //线段树
        int lSum;// 以左区间为端点的最大子段和
        int rSum;// 以右区间为端点的最大子段和
        int iSum;// 区间所有数的和
        int mSum;// 该区间的最大子段和
        wtevTree(int l, int r, int i, int m) { // 构造函数
            lSum = l;
            rSum = r;
            iSum = i;
            mSum = m;
        }
    }

    // 通过既有的属性,计算上一层的属性,一步步往上返回,获得线段树
    public static wtevTree pushUp(wtevTree leftT, wtevTree rightT) {
        // 新子段的lSum等于左区间的lSum或者左区间的 区间和 加上右区间的lSum
        int l = Math.max(leftT.lSum, leftT.iSum + rightT.lSum);
        // 新子段的rSum等于右区间的rSum或者右区间的 区间和 加上左区间的rSum
        int r = Math.max(leftT.rSum + rightT.iSum, rightT.rSum);
        // 新子段的区间和等于左右区间的区间和之和
        int i = leftT.iSum + rightT.iSum;
        // 新子段的最大子段和,其子段有可能穿过左右区间,或左区间,或右区间
        int m = Math.max(leftT.rSum + rightT.lSum, Math.max(leftT.mSum, rightT.mSum));
        return new wtevTree(l, r, i, m);
    }

    // 递归建立和获得输入区间所有子段的结构
    public static wtevTree getInfo(int[] nums, int left, int right) {
        if (left == right) // 若区间长度为1,其四个子段均为其值
            return new wtevTree(nums[left], nums[left], nums[left], nums[left]);
        int mid = (left + right) >> 1;// 获得中间点mid,右移一位相当于除以2,运算更快
        wtevTree leftT = getInfo(nums, left, mid);
        wtevTree rightT = getInfo(nums, mid + 1, right);//mid+1,左右区间没有交集。
        return pushUp(leftT, rightT);//递归结束后,做最后一次合并
    }


    public static void main(String[] args) {
        int[] test1 = {-2,1,-3,4,-1,2,1,-5,4};
        int[] test2 = {-1};
        int[] test3 = {1,2,3,4,5};
        System.out.println(maxSubArray2(test3));
    }

}
