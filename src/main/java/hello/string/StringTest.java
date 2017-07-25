package hello.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by scnyig on 7/24/2017.
 * 用一个哈希表记录字符串s中字母到字符串t中字母的映射关系，一个集合记录已经映射过的字母。
 * 或者用两个哈希表记录双向的映射关系。这里不能只用一个哈希表，因为要排除egg->ddd这种多对一的映射。
 */
public class StringTest {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            char sc = s.charAt(i), tc = t.charAt(i);
            if(map.containsKey(sc)){
                // 如果已经给s中的字符建立了映射，检查该映射是否和当前t中字符相同
                if(tc != map.get(sc)) return false;
            } else {
                // 如果已经给t中的字符建立了映射，就返回假，因为出现了多对一映射
                if(set.contains(tc)) return false;
                map.put(sc, tc);
                set.add(tc);
            }
        }
        return true;
    }

    public int addDigits(int num) {
        // Write your code here

        int result = getnext(num);
        while(result >= 10) {
            result = getnext(num);
        }
        return result;
    }

    public int getnext(int next) {
        String a = String.valueOf(next);
        int nex = 0;
        for(int i=0;i < a.length();i++) {
            int value = Integer.parseInt(String.valueOf(a.charAt(i)));
            nex += value;
        }
        return nex;
    }

    /**
     * Longest Common Prefix
     * http://wiki.jikexueyuan.com/project/leetcode-book/13.html
     */
    public String getLongestPrefix(String[] data) {
        if(data == null) {
            return "";
        }
        int length = data.length;

        if (length == 1) {
            return data[0];
        }

        int minIndex = 0;
        String shortestStrin = data[0];
        for (int i = 0; i < length; i++) {
            if (data[i].length() < shortestStrin.length()) {
                minIndex = i;
                shortestStrin = data[i];
            }
        }

        String result = "";
        int j = shortestStrin.length();
        for (;j >= 0; j--) {
            result = data[minIndex].substring(0, j);

            int i = 0;
            for (; i < data.length; i++) {
                if(i == minIndex) {
                    break;
                }
                String substr = data[i].substring(0, j);
                if(substr != result) {
                    break;
                }
            }

            if (i == data.length) {
                return result;
            }
        }

        return result;
    }
}
