package hello.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scnyig on 7/18/2016.
 */
public class LRUCache {
    private Map<Integer, CacheNode> cache = new HashMap<>();
    private CacheNode head = null;
    private CacheNode tail = null;
    private int capacity;
    private int count = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        CacheNode result = cache.get(key);
        if (result == null) {
            return -1;
        }

        moveNodeToHead(result);

        return result.value;
    }

    public void set(int key, int value) {
        CacheNode result = cache.get(key);
        if (result == null) {
            if (count == capacity) {
                evictTheOldestNode();

            } else {
                count++;
            }
            CacheNode cacheNode = new CacheNode(key, value);
            cache.put(key, cacheNode);

            if (head == null) {
                head = cacheNode;
                tail = cacheNode;
            } else {
                cacheNode.next = head;
                head.prev = cacheNode;
                head = cacheNode;
            }

        } else {

            moveNodeToHead(result);

            result.value = value;
        }

    }

    private void evictTheOldestNode() {
        cache.remove(tail.key);
        if (capacity == 1) {
            head = null;
            tail = null;
        } else {
            // evict the oldest one
            CacheNode prev = tail.prev;

            prev.next = null;
            tail.prev = null;

            tail = prev;
        }
    }

    private void moveNodeToHead(CacheNode result) {
        // it is the head
        if (result.prev == null) {
            return;
        }


        // remove cached node from the list
        if (result.next != null) {
            result.next.prev = result.prev;
        } else {
            // it is the tail
            tail = result.prev;

        }

        result.prev.next = result.next;

        // insert node in the head
        result.next = head;
        head.prev = result;

        result.prev = null;
        head = result;

        // the capacity is 1
        if (tail == null) {
            tail = head;
        }
    }

    public static class CacheNode {
        public int key;
        public int value;

        public CacheNode prev;
        public CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
