public class ReverseString {

    public static void reverseString(char[] s) {
        int n = s.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        char[] s = {'H','e','l'};
        reverseString(s);
        System.out.println(s);
    }

}
