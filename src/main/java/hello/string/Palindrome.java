package hello.string;

/**
 * Created by scnyig on 8/25/2016.
 */
public class Palindrome {
    public static void main(String[] args) {
        String ss = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(ss);

        System.out.println(result);
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
