package hello.zuroa.sasdp;

import java.util.*;

/**
 * Created by scnyig on 9/6/2017.
 */
public class TopNPopularPathServiceImpl implements TopNPopularPathService {
    @Override
    public void setup(String[][] data) {

    }

    @Override
    public String[] getTopNPopularPaths(int n) {
        //get top n three path from treemap
        return new String[0];
    }

    /*
    * parse the log file to user -> linkedlist into map
     */
    public static Map<User, LinkedList> parseLog() {
        return new HashMap<User, LinkedList>();
    }

    public static TreeMap<Integer, ThreePath> parseToThreePathMap() {

        return null;
    }


}
