public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int n: nums) {
            res ^= n;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3};
        System.out.println(singleNumber(nums));
    }

}
