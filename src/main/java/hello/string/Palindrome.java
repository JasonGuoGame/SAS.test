package hello.string;

/**
 * Created by scnyig on 8/25/2016.
 */
public class Palindrome {
    public static void main(String[] args) {
        String ss = "A man, a plan, a canal: Panama";
        String s = "abcdzdc";
        String sss = s.substring(0, s.length());
        boolean isPal = isPalindrome(ss);
        String result = longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        String result = new String();
        if(s == null || s.isEmpty()) return result;

        int longest = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j <= s.length();j++){
                String sub = s.substring(i, j);
                if (isPalindromeSub(sub) && sub.length() > longest) {
                    longest = sub.length();
                    left = i;
                    right = j;
                }
            }
        }

        return s.substring(left,right);
    }

    public static boolean isPalindromeSub(String ss) {
        if (ss == null || ss.isEmpty()) return false;

        for (int i =0; i < ss.length();i++) {
            if (ss.charAt(i) != ss.charAt(ss.length() - 1 - i)){
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        if("".equals(s) || s.length() == 0) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }
}
