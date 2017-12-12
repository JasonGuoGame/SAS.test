package hello.linkedlist.staticlist;

/**
 * Created by scnyig on 12/4/2017.
 * http://blog.csdn.net/yannanying/article/details/46956355
 * http://blog.csdn.net/yannanying/article/details/46956355
 */
public class StaticList<T> implements StaticListInterface<T> {
    private StaticListNode[] nodes;
    private static final int maxSize = 15;

    public StaticList() {
        this(maxSize);
    }

    public StaticList(int maxSize) {
        nodes = new StaticListNode[maxSize];
        for (int i = 0; i < maxSize -1; i++) {
            nodes[i] = new StaticListNode(null, i+1);
        }
        nodes[maxSize-1] = new StaticListNode(null,0);
    }

    @Override
    public int length() {
        int cur = nodes[maxSize-1].getCur();
        int length = 0;
        while (cur!=0) {
            cur = nodes[cur].getCur();
            length++;
        }
        return length;
    }

    //向备用链表申请一个数组单元，给插入操作使用；若备用链表非空，则返回备用首结点的下标，否则返回0
    public int applySpaceFromBackupList() {
        int i = getBackupListFirstIndex();
        if (i != 0) {
            nodes[0].setCur(i+1);
        }

        return i;
    }

    @Override
    public int getBackupListFirstIndex() {
        return nodes[0].getCur();
    }

    //把下标为k的空闲结点回收到备用链表,即将k作为备用链表首结点位置，数组第一个元素中的cursor指向第k个单元
    @Override
    public T increaseSpaceToBackupList(int k) {
        T tmp = (T)nodes[k].getData();
        int m = nodes[0].getCur();
        nodes[k].setCur(m);
        nodes[0].setCur(k);
        return tmp;
    }

    //尾插
    @Override
    public boolean insert(T element) {
        int i = length();
        return insert(i, element);
    }

    //在表中第i个位置插入数据元素T e
    @Override
    public boolean insert(int i, T element) {
        if (i >= maxSize-1) {
            return  false;
        }

        if (i > length()) {
            i = length() + 1;
        }
        if (i < 1) {
            i = 1;
        }
        int k = maxSize - 1;
        //向备用链表申请空间，以存放要添加的数据元素结点
        int m = applySpaceFromBackupList();
        if (m > 0) {
            //找到数组第i个元素的前一个元素的位置
            for (int j = 1; j < i; j++) {
                k = nodes[k].getCur();
            }
            //创建一个新的结点，数据是element,cursor指向第i个元素
            //将新生成的结点放入链表的最后一个单元，即备用链表的上一个单元
            nodes[m] = new StaticListNode(element, nodes[k].getCur());
            //使当前数组第i个元素前面元素的cursor指向链表尾结点
            nodes[k].setCur(m);
        }

        return  true;
    }

    @Override
    public T remove(int i) {
        if(i > maxSize -1) {
            return null;
        }
        if (i < 1) {
            i = 1;
        }
        int length = length();
        if (i>length) {
            i = length;
        }

        int k = nodes[maxSize - 1].getCur();
        for (int j = 1; j < i;j++) {
            k = nodes[k].getCur();
        }

        int m = nodes[k].getCur();
        //将前一个数据元素的cursor设置为当前位置上的cursor,即让当前元素的上一个元素的cursor指向当前元素的下一个元素
        nodes[k].setCur(nodes[m].getCur());
        //将删除的元素空间回收至备用链表，并将删除位置作为添加元素的优先存储空间
        return increaseSpaceToBackupList(m);
    }

    @Override
    public void removeAll() {
        int fircur = nodes[0].getCur();
        while (fircur != 1) {
            remove(length());
        }
    }
}
