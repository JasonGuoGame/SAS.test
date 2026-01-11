package hello.string;

/**
 * 标准的 Brute Force (BF) 字符串匹配算法，也常被称为“朴素模式匹配算法
 * Java 的 String.indexOf(String str) 在早期版本中也采用类似 BF 的逻辑，
 * 但现代JDK可能会根据字符串长度动态选择更高效的算法（如改进的跳跃查找），但其底层的思维原型依然是这段代码
 * Created by scnyig on 12/13/2017.
 */
public class BFAlgorithm {
    public static int indexOf(String source, String pattern) {
        int slength = source.length();
        int plength = pattern.length();
        int i = 0;
        int j = 0;
        while (i < slength && j < plength) {
            if (source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == plength) {
            return i - j;
        } else {
            return -1;
        }
    }
}
