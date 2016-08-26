package hello.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scnyig on 8/26/2016.
 */
public class LongestWord {
    public static List longestWords(String[] directory) {
        List<String> result = new ArrayList<>();
        if (directory.length ==0 || directory== null) return result;

        for (int i = 0; i < directory.length; i++) {
            if(result.isEmpty() || directory[i].length() > result.get(0).length()) {
                result.clear();
                result.add(directory[i]);
            } else if(directory[i].length() == result.get(0).length()) {
                result.add(directory[i]);
            }
        }

        return result;
    }
}
