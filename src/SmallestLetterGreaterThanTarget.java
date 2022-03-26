public class SmallestLetterGreaterThanTarget {

    // 官方二分查找，可以直接用 %
    public static char nextGreatestLetter1(char[] letters, char target) {
        int lo = 0, hi = letters.length;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (letters[mi] <= target) lo = mi + 1;
            else hi = mi;
        }
        return letters[lo % letters.length];
    }

    // Attempt 1: Note that the letters wrap around
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;
        if (target < letters[low]) {
            return letters[low];
        }
        if (target >= letters[high]) {
            return letters[low];
        }

        while (low < high) {
            int mid = (low + high) >>> 1;
            if (target > letters[mid]) {
                low = mid + 1;
            } else if (target < letters[mid]){
                high = mid;
            } else {
                while (mid < letters.length - 1 && letters[mid] == target) {
                    mid++;
                }
                return letters[mid];
            }
        }
        return letters[low];
    }


    public static void main(String[] args) {
        char[] test = {'c','f','j'};
        System.out.println(nextGreatestLetter1(test, 'j'));
    }

}
