package hello.huffman;

/**
 * Created by scnyig on 9/23/2017.
 */
public class Node implements Compare<Node> {
    //节点的优先级
    private int nice;

    //字符出现的频率(次数)
    private int count;

    //文本中出现的字符串
    private String str;

    //左孩子
    private Node leftNode;

    //右孩子
    private Node rightNode;

    //对应的二进制编码
    private String code;

    public Node(){
    }

    public Node(int nice, String str, int count){
        this.nice = nice;
        this.str = str;
        this.count = count;
    }

    //把节点(权值，频率)相加，返回新的节点
    public Node add(Node node){
        Node n = new Node();
        n.nice = this.nice + node.nice;
        n.count = this.count + node.count;
        return n;
    }

    public boolean less(Node node) {
        return this.nice < node.nice;
    }


    public String toString(){
        return String.valueOf(this.nice);
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
