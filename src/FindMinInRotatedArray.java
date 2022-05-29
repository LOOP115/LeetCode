public class FindMinInRotatedArray {

    // 官方 BS  简练很多  100%
    public static int findMin1(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        while(low < high){
            int mid = (high+low)/2;
            // 如果中间值小于最大值，则最大值减小
            // 疑问：为什么 high = mid，而不是 high = mid-1
            // 解答：{4,5,1,2,3}，如果high=mid-1，则丢失了最小值1
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                // 如果中间值大于最大值，则最小值变大
                // 疑问：为什么 low = mid+1;而不是 low = mid;
                // 解答：{4,5,6,1,2,3}，nums[mid]=6，low=mid+1,刚好nums[low]=1
                // 继续疑问：上边的解释太牵强了，难道没有可能low=mid+1,正好错过了最小值
                // 继续解答：不会错过!!! 如果nums[mid]是最小值的话，则其一定小于nums[high],走if，就不会走else了
                low = mid+1;
            }
        }
        // 疑问：为什么while的条件是low<high,而不是low<=high呢
        // 解答：low<high，假如最后循环到{*,10,1,*}的这种情况时，nums[low]=10,nums[high]=1,nums[mid]=10,low=mid+1,
        // 直接可以跳出循环了,所以low<high,此时low指向的就是最小值的下标;
        // 如果low<=high的话，low=high，还会再不必要的循环一次，此时最后一次循环的时候会发生low==high==mid，
        // 则nums[mid]==nums[high]，则会走一次else语句，则low=mid+1,此时low指向的是最小值的下一个下标，
        // 则需要return[low-1]
        return nums[low];
    }


    // Attempt1: BS  受到 33 题影响  100%
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // 无翻转
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[left] <= nums[mid]) {
                // [left, mid] 有序
                if (nums[mid] < nums[right]) {
                    if (nums[left - 1] < nums[left]) {
                        // min 存在于 [0, left], 重置 left 和 right
                        right = left - 1;
                        left = 0;
                    } else {
                        // min 存在于 [left, mid - 1]
                        right = mid - 1;
                    }
                } else {
                    // min 存在于 [mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // [mid, right] 有序
                if (nums[mid] < nums[right]) {
                    // min 存在于 [mid - 1, right]
                    if (nums[mid - 1] > nums[mid]) {
                        // 数组中若 n[x] > n[x+1], 则 x 为翻转点，必为 min
                        left = mid;
                        break;
                    }
                    left = mid - 1;
                } else {
                    // min 存在于 [left, mid + 1]
                    right = mid + 1;
                }
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        int[] test = {266,267,268,269,271,278,282,292,293,298,6,9,15,19,21,26,33,35,37,38,39,46,49,54,65,71,74,77,79,82,83,88,92,93,94,97,104,108,114,115,117,122,123,127,128,129,134,137,141,142,144,147,150,154,160,163,166,169,172,173,177,180,183,184,188,198,203,208,210,214,218,220,223,224,233,236,241,243,253,256,257,262,263};
        System.out.println(findMin(test));
    }

}
