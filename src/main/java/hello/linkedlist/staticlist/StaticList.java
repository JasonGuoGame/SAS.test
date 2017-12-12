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

    //������������һ�����鵥Ԫ�����������ʹ�ã�����������ǿգ��򷵻ر����׽����±꣬���򷵻�0
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

    //���±�Ϊk�Ŀ��н����յ���������,����k��Ϊ���������׽��λ�ã������һ��Ԫ���е�cursorָ���k����Ԫ
    @Override
    public T increaseSpaceToBackupList(int k) {
        T tmp = (T)nodes[k].getData();
        int m = nodes[0].getCur();
        nodes[k].setCur(m);
        nodes[0].setCur(k);
        return tmp;
    }

    //β��
    @Override
    public boolean insert(T element) {
        int i = length();
        return insert(i, element);
    }

    //�ڱ��е�i��λ�ò�������Ԫ��T e
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
        //������������ռ䣬�Դ��Ҫ��ӵ�����Ԫ�ؽ��
        int m = applySpaceFromBackupList();
        if (m > 0) {
            //�ҵ������i��Ԫ�ص�ǰһ��Ԫ�ص�λ��
            for (int j = 1; j < i; j++) {
                k = nodes[k].getCur();
            }
            //����һ���µĽ�㣬������element,cursorָ���i��Ԫ��
            //�������ɵĽ�������������һ����Ԫ���������������һ����Ԫ
            nodes[m] = new StaticListNode(element, nodes[k].getCur());
            //ʹ��ǰ�����i��Ԫ��ǰ��Ԫ�ص�cursorָ������β���
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
        //��ǰһ������Ԫ�ص�cursor����Ϊ��ǰλ���ϵ�cursor,���õ�ǰԪ�ص���һ��Ԫ�ص�cursorָ��ǰԪ�ص���һ��Ԫ��
        nodes[k].setCur(nodes[m].getCur());
        //��ɾ����Ԫ�ؿռ������������������ɾ��λ����Ϊ���Ԫ�ص����ȴ洢�ռ�
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
