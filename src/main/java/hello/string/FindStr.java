package hello.string;

/**
 * Created by scnyig on 7/11/2016.
 */
public class FindStr {

    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }

        int i, j;
        for (i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                } //if
            } //for j
            if (j == target.length()) {
                return i;
            }
        } //for i

        // did not find the target
        return -1;
    }

    public static boolean anagram(String s, String t) {
        // write your code here
        if (s==null || t==null || s.length()!=t.length()) return false;
            int[] ss = new int[256];
            int[] tt = new int[256];
            for (int i=0; i<s.length(); i++) {
                ss[s.charAt(i)]++;
                tt[t.charAt(i)]++;
            }
            for (int j=0; j<256; j++) {
                if (ss[j] != tt[j])
                    return false;
            }
        return true;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "acbd";
        boolean flag = anagram2(a,b);
        System.out.println(flag);
    }

    public static boolean anagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[(int) t.charAt(i)]--;
            if (count[(int) t.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

}
