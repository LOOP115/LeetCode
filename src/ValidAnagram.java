public class ValidAnagram {

    // Attempt 1  Array 计数  O(n)  100%
    // 还可以先 sort 然后比较两个 string 是否 equal，复杂度为 O(nlogn)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c: s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            int count = --cnt[c - 'a'];
            if (count < 0) {
                return false;
            }
        }
        return true;
    }

}
