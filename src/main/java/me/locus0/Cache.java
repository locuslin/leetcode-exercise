package me.locus0;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022/3/31/031.
 *
 * @author LingChuan
 */
class LRUCache2 {

    private int capacity;

    private Map<Integer, Node> cache;

    private Node head;

    private Node tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    private void move2Head(Node node) {
        if (node != head) {
            //连接原pre及next
            if (node.pre != null) {
                node.pre.next = node.next;
            }
            if (node.next != null) {
                node.next.pre = node.pre;
            }

            if (node == tail) {
                tail = node.pre;
            }

            //修改head
            node.next = head;
            if (head != null) {
                head.pre = node;
            }
            node.pre = null;
            head = node;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            move2Head(node);
        } else {
            node = new Node();
            node.value = value;
            node.key = key;

            //淘汰最后一个key
            if (cache.size() >= capacity) {
                cache.remove(tail.key);
                if (tail.pre != null) {
                    //删除tail节点赋值为原来的pre
                    tail.pre.next = null;
                    tail = tail.pre;
                    //此处实际上会存在问题，若长度为1，这里的pre节点为为空，导致没有pre，会报错
                }
                insertHead(node);
                cache.put(key, node);
            } else {
                insertHead(node);
                cache.put(key, node);
                if (tail == null) {
                    tail = head;
                }
            }
        }
    }

    private void insertHead(Node node) {
        //插入头节点
        node.next = head;
        if (head != null) {
            head.pre = node;
        }
        head = node;
    }

    // @ToString
    private static class Node {
        Node pre;
        Node next;
        int value;
        int key;
    }

    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }
}