package hello.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scnyig on 7/25/2016.
 */
public class MyLRUCache {
    class CacheNode {
        public CacheNode pre;
        public CacheNode next;
        public String key;
        public String value;

        public CacheNode(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public CacheNode head;
    public CacheNode tail;
    public Map<String,CacheNode> cache = new HashMap<String, CacheNode>();
    private int count;
    private int capacity;

    public MyLRUCache(int capacty) {
        this.capacity = capacty;
    }

    private void moveToHead(CacheNode result) {
        if(result.pre == null) {
            return;
        }

        //remove the result from linked list
        CacheNode pre = result.pre;

        if(result.next != null) { //don't be tail
            CacheNode next = result.next;
            pre.next = next;
            next.pre = pre;
        } else {
            pre.next = null;
        }
        //add the result to head

        result.next = head;
        result.pre = null;
        head.pre = result;
        head = result;

        if(tail == null) {
            tail = head;
        }
    }

    private void removeTailNode() {
        cache.remove(tail.key);
        if (capacity == 1) {
            tail = null;
            head = null;
            count = 0;
        } else {
            CacheNode pre = tail.pre;
            pre.next = null;
            tail.pre = null;
            tail = pre;
            count--;
        }
    }

    public void setCache(String key, String value) {
        CacheNode node = cache.get(key);
        if (node == null) {
            if(capacity == count) {
                removeTailNode();
            } else  {
                count++;
            }
            CacheNode rr = new CacheNode(key, value);
            rr.next = head;
            head.pre = rr;
            head = rr;
        } else {
            //update the value
            moveToHead(node);
            node.value = value;
        }
    }

    public String getCache(String key) {
        CacheNode node = cache.get(key);
        if (node == null) return null;

        moveToHead(node);

        return node.value;
    }
}
