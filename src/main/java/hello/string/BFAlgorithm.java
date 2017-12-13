package hello.string;

/**
 * Created by scnyig on 12/13/2017.
 */
public class BFAlgorithm {
    public static int indexOf(String source, String pattern) {
        int slength = source.length();
        int plength = pattern.length();
        int i = 0;
        int j = 0;
        while (i < slength  && j < plength){
            if (source.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }else {
                i = i - j + 1;
                j = 0;
            }
        }

        if(j == plength) {
            return i - j;
        }else {
            return -1;
        }
    }
}
