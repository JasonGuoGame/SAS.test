package hello.string;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by scnyig on 7/26/2017.
 */
public class ValidParentheses {
    /**
     * http://www.jiuzhang.com/solutions/valid-parentheses/
     * @param s
     * @return
     */
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if ("({[".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
    }

    /**
     * https://leetcode.com/problems/longest-valid-parentheses/#/solution
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j+=2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }

    /**
     * generate parenthess
     * @param n
     * @return
     * http://www.jiuzhang.com/solutions/generate-parentheses/
     */
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n <= 0) {
            return result;
        }
        helper(result, "", n, n);
        return result;
    }

    public static void helper(ArrayList<String> result,
                       String paren, // current paren
                       int left,     // how many left paren we need to add
                       int right) {  // how many right paren we need to add
        if (left == 0 && right == 0) {
            result.add(paren);
            return;
        }

        if (left > 0) {
            helper(result, paren + "(", left - 1, right);
        }

        if (right > 0 && left < right) {
            helper(result, paren + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> strings = generateParenthesis(1);
        System.out.println(strings);
    }
}
