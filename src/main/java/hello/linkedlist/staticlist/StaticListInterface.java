package hello.linkedlist.staticlist;

/**
 * Created by scnyig on 12/4/2017.
 */
public interface StaticListInterface<T> {
    int length();//��̬������

    int getBackupListFirstIndex();//��ȡ��ǰ����������׽���ַ

    T increaseSpaceToBackupList(int k);//�����пռ��������������

    boolean insert(T element);//β��

    boolean insert(int i, T element);//�ڵ�i��λ�ò���Ԫ��element

    T remove(int i);//ɾ�����е�i��λ�õ�Ԫ��

    void removeAll();//ɾ����������Ԫ��
}
