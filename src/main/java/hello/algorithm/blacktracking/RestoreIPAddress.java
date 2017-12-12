package hello.algorithm.blacktracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scnyig on 10/11/2017.
 */
public class RestoreIPAddress {
    public static void main(String[] args) {
        String ip = "25525511135";
        List<String> ipAddresses = restoreIpAddresses(ip);
        System.out.println(ipAddresses);
    }
    public static List<String> restoreIpAddresses(String s) {
        List<String> solutions = new ArrayList<String>();
        restoreIp(s, solutions, 0, "", 0);
        return solutions;
    }

    private static void restoreIp(String ip, List<String> solutions, int idx, String restored, int count) {
        if (count > 4) return;
        //终止条件
        if (count == 4 && idx == ip.length()) solutions.add(restored);

        //循环条件
        for (int i=1; i<4; i++) {
            if (idx + i > ip.length()) {
                break;
            }
            String s = ip.substring(idx,idx+i);
            if ((s.startsWith("0") && s.length()>1) || (i==3 && Integer.parseInt(s) >= 256)) {
                continue;
            }
            restoreIp(ip, solutions, idx+i, restored+s+(count == 3 ? "" : "."), count + 1);
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        // write your code here
        List<String> coms = new ArrayList<String>();
        if(s.length()<4 || s.length()>12) {
            return coms;
        }

        dfs(s, coms, "", 0, 0);

        return coms;
    }

    public void dfs(String s,List<String> coms, String address, int seg, int index){
        if(seg >=3) {
            String ip = s.substring(index);
            if(isValid(ip)){
                String ipa = address + ip;
                coms.add(ipa);

            }
            return;
        }

        for(int i=1;i<4 && index+i<s.length();i++) {
            String ip = s.substring(index, index+i);
            if(isValid(ip)) {
                String ipadress = address + ip + ".";
                dfs(s,coms,ipadress,seg+1,index+i);
            }
        }
    }

    public boolean isValid(String seg) {
        if(seg.charAt(0)=='0'&&seg.length()>1) {
            return false;
        }else if(Integer.valueOf(seg)>=256) {
            return false;
        }

        return true;
    }
}
