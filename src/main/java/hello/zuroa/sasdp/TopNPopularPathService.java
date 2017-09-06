package hello.zuroa.sasdp;

/**
 * Created by scnyig on 9/6/2017.
 */
interface TopNPopularPathService {
    void setup(String[][] data);
    String[] getTopNPopularPaths(int n);
}
