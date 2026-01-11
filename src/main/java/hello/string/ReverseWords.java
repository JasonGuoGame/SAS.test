package hello.string;

/**
 * LeetCode 第 151 题：反转字符串中的单词
 * Created by scnyig on 8/12/2016.
 * Reverse words in string
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]).append(" ");
            }
        }

        return sb.toString().length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
