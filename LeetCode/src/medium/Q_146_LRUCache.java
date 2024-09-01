package medium;

import java.util.HashMap;
import java.util.Map;

public class Q_146_LRUCache {
    class Node {
        int key;
        int value;
        Node prev, next;

        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    //create a head node and a tail node
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    public Q_146_LRUCache(int capacity) {
        this.capacity = capacity;
        //initialy head is connected to tail and tail is connected to head
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;//if not contains the key than return -1
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        //first remove it from the cache map
        map.remove(node.key);
        //break the next link
        node.prev.next = node.next;
        //break the previous link
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        //first add it to the cache map
        map.put(node.key, node);
        //make a pointer point to just next element of head
        //headNEP = headNextElementPointer
        Node headNEP = head.next;
        head.next = node;
        node.prev = head;
        headNEP.prev = node;
        node.next = headNEP;
    }
}
