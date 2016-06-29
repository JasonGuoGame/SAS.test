package hello.wordsimilar;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.List;

/**
 * Created by scnyig on 6/2/2016.
 */
public class LevenshteinDistance {
    public static void main0(String[] args) {
        String a = "aaadddeee";
        String b = "efadfe";
        int length = computeLevenshteinDistance(a, b);
        System.out.println(length);
    }

    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(String lhs, String rhs) {
        if (lhs == null || rhs == null) {
            return rhs == null ? lhs.length() : rhs.length();
        }

        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }
}
