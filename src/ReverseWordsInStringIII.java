public class ReverseWordsInStringIII {

    // String is immutable in java so that extra space is needed
    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        int n = str.length;
        int left = 0, right;
        for (int i=0; i<n; i++) {
            if (str[i] == ' ' || i + 1 == n) {
                if (i + 1 == n) {
                    right = i;
                } else {
                    right = i -1 ;
                }
                while (left <= right) {
                    char temp = str[right];
                    str[right] = str[left];
                    str[left] = temp;
                    right--;
                    left++;
                }
                left = i + 1;
            }
        }
        return new String(str);
    }


    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }

}
