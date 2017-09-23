package hello.huffman;

/**
 * Created by scnyig on 9/23/2017.
 * http://www.cnblogs.com/junyuhuang/p/4127095.html
 */

/******************************************************************************
 *  Compilation:  javac Huffman.java
 *  Execution:    java Huffman - < input.txt   (compress)
 *  Execution:    java Huffman + < input.txt   (expand)
 *  Dependencies: BinaryIn.java BinaryOut.java
 *  Data files:   http://algs4.cs.princeton.edu/55compression/abra.txt
 *                http://algs4.cs.princeton.edu/55compression/tinytinyTale.txt
 *                http://algs4.cs.princeton.edu/55compression/medTale.txt
 *                http://algs4.cs.princeton.edu/55compression/tale.txt
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 *  % java Huffman - < abra.txt | java BinaryDump 60
 *  010100000100101000100010010000110100001101010100101010000100
 *  000000000000000000000000000110001111100101101000111110010100
 *  120 bits
 *
 *  % java Huffman - < abra.txt | java Huffman +
 *  ABRACADABRA!
 *
 ******************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  The {@code Huffman} class provides static methods for compressing
 *  and expanding a binary input using Huffman codes over the 8-bit extended
 *  ASCII alphabet.
 *  <p>
 *  For additional documentation,
 *  see <a href="http://algs4.cs.princeton.edu/55compress">Section 5.5</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Huffman {
    //优先队列
    private PriorityQueue<Node> priorQueue;

    //需要处理的文本
    private String[] text;

    //文本处理后的统计信息
    private Map<String, Integer> statistics;

    //huffman编码最终结果
    private Map<String, String> result;

    public Huffman(String text) {
        this.text = text.split("\\W+");
        init();
    }

    private void init() {
        statistics = new HashMap<String, Integer>();
        result = new HashMap<String, String>();
    }

    //获取字符串统计信息，得到如"abc":3,"love":12等形式map
    private void getStatistics() {
    int count;
    for (String c : text) {
     if (statistics.containsKey(c)) {
             count = statistics.get(c);
             count++;
             statistics.put(c, count);
         } else {
             statistics.put(c, 1);
         }
    }
    }

    //构建huffman树
    private void buildTree() {
        List<Node> list = new ArrayList<Node>();
        list.add(new Node(2222, "123", 2222));        //因为优先队列的特殊性，添加这个不使用的节点
        //把字符串信息储存到节点中，并把节点添加到arrayList中
        for (String key : statistics.keySet()) {
            Node leaf = new Node(statistics.get(key), key, statistics.get(key));
            list.add(leaf);
        }
        Node tree = null;        //用于储存指向huffman树根节点的指针
        priorQueue = new PriorityQueue<Node>(list);        //以上面节点为元素，构建优先队列
        priorQueue.buildHeap();
        Node first = null;
        Node second = null;
        Node newNode = null;
        do {
            first = priorQueue.pop();        //取出队首的元素,作为左孩子节点
            second = priorQueue.pop();        //取出队首的元素,作为右孩子节点
            newNode = first.add(second);    //构建父节点
            priorQueue.add(newNode);        //把父节点添加到队列中
            newNode.setLeftNode(first);
            newNode.setRightNode(second);
            tree = newNode;            //把tree指向新节点
        } while (priorQueue.size() > 2);        //由于队列中有一个元素是不使用的，所以队列只剩最后一个元素(实际就是队列只有2个元素)时就该退出循环了。
        //最后剩下一个节点是根节点，把它取出来，并拼装树
        Node root = priorQueue.pop();
        root.setCode("0");
        root.setLeftNode(tree.getLeftNode());
        root.setRightNode(tree.getRightNode());
        tree = null;
        setCodeNum(root);        //遍历树，为每个节点编码
        System.out.println("----------------------------");
        System.out.println(result);
    }

    public void buildHuffman(){
        getStatistics();        //收集统计信息
        buildTree();
        for (String c : statistics.keySet()) {
            System.out.println(c + ":" + statistics.get(c));
        }
    }

    //编码
    private void setCodeNum(Node tree){
        if(null == tree){
            return;
        }
        Node left = tree.getLeftNode();
        Node right = tree.getRightNode();
        if (left !=null){
            left.setCode("0" + tree.getCode());        //左孩子的码为0
            if (statistics.containsKey(left.getStr())){
                //如果节点在统计表里，把它添加到result中
                result.put(left.getStr(), left.getCode());
            }
        }
        if (right != null){
            right.setCode("1" + tree.getCode());        //右孩子的码为1
            if (statistics.containsKey(right.getStr())){
                //如果节点在统计表里，把它添加到result中
                result.put(right.getStr(), right.getCode());
            }
        }
        setCodeNum(left);        //递归
        setCodeNum(right);        //递归

    }
}
