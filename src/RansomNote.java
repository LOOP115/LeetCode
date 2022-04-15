import java.util.HashMap;

public class RansomNote {

    // Attempt 1  HashMap
    public static boolean canConstruct1(String ransomNote, String magazine) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        for (int i=0; i<magazine.length(); i++) {
            char c = magazine.charAt(i);
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
        }
        for (int i=0; i<ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            int count = cnt.getOrDefault(c, 0) - 1;
            if (count == -1) {
                return false;
            }
            cnt.put(c, count);
        }
        return true;
    }

    // Attempt  使用 Array 计数  99.95%
    public static boolean canConstruct2(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        for (int i=0; i<ransomNote.length(); i++) {
            int count = --cnt[ransomNote.charAt(i) - 'a'];
            if (count < 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String r = "a";
        String m = "b";
        System.out.println(canConstruct2(r, m));
    }

}
