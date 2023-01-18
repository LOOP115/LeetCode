public class ContainerWithMostWater {

    // 双指针  58.80%  O(n) O(1)
    public static int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    // 精简写法  90.73%
    public int maxArea1(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] test2 = new int[]{1, 1};
        System.out.println(maxArea(test1));
    }

}
