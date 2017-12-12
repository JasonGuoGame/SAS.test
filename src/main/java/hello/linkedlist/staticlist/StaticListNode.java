package hello.linkedlist.staticlist;

/**
 * Created by scnyig on 12/4/2017.
 */
public class StaticListNode<T> {
    private T data;
    private int cur;

    public StaticListNode(T data, int cur) {
        this.data = data;
        this.cur = cur;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
