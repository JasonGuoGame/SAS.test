package hello.huffman;

/**
 * Created by scnyig on 9/23/2017.
 */
import java.util.List;

public class PriorityQueue <T extends Compare<T>>{
    public List<T> list = null;

    public PriorityQueue(List<T> list){
        this.list = list;
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public int size(){
        return list.size();
    }

    //移除指定索引的元素
    public void remove(int number){
        int index = list.indexOf(number);
        if (-1 == index){
            System.out.println("data do not exist!");
        return;
        }
        list.remove(index);
        //每次删除一个元素都需要重新构建队列
        buildHeap();
    }

    //弹出队首元素，并把这个元素返回
    public T pop(){
        //由于优先队列的特殊性，第一个元素(索引为0)是不使用的
        if (list.size() == 1){
            return null;
        }
        T first = list.get(1);
        list.remove(1);
        buildHeap();
        return first;

    }

    //加入一个元素到队列中
    public void add(T object){
        list.add(object);
        buildHeap();
    }

    //维护最小堆
    private List<T> minHeap(List<T> list, int position, int heapSize){
        int left = 2 * position;        //得到左孩子的位置
        int right = left + 1;        //得到右孩子的位置
        int min = position;        //min储存最小值的位置，暂时假定当前节点是最小节点
        //寻找最小节点
        if (left < heapSize  &&  list.get(left).less(list.get(min))){
            min = left;
        }
        if (right < heapSize && list.get(right).less(list.get(min))){
            min = right;
        }

        if (min != position){
            exchange(list, min, position);        //交换当前节点与最小节点的位置
            minHeap(list, min, heapSize);        //重新维护最小堆
        }
        return list;
    }

    //交换元素位置
    private List<T> exchange(List<T> list, int former, int latter){
        T temp = list.get(former);
        list.set(former, list.get(latter));
        list.set(latter, temp);
        return list;
    }

    //构建最小堆
    public List<T> buildHeap(){
        int i;
        for (i = list.size() - 1; i > 0; i--){
            minHeap(list, i, list.size());
        }
        return list;
    }
}
