package 找出包含的字符串;

/**
 * For a given source string and a target string,
 * you should output the first index(from 0) of target string in source string.
 * <p>
 * If target does not exist in source, just return -1.
 */
public class strStr {
    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
        if (needle.isEmpty()) return 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length())
                    return i;

            }

        }
        return 0;
    }

}
