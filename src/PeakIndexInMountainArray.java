public class PeakIndexInMountainArray {

    public static int peakIndexInMountainArray(int[] arr) {
        int head = 0;
        int tail = arr.length - 1;
        while (head != tail) {
            if (arr[head] < arr[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int[] test = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(test));
    }

}
