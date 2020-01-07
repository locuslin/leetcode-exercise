package me.locus0;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * Created on 2020/1/7.
 *
 * @author LingChuan
 */
public class LRUCache {

    private final int capacity;

    private final Map<Integer, ValueNode> cache = new HashMap<>();

    private ValueNode head;

    private ValueNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        ValueNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    /**
     * 将链表中的某个节点移动到头部
     *
     * @param node
     */
    private void moveToHead(ValueNode node) {
        if (node == head) {
            return;
        }
        //把以前的pre跟next连起来
        ValueNode pre = node.pre;
        ValueNode next = node.next;
        if (pre != null) {
            pre.next = next;
        }
        if (next != null) {
            next.pre = pre;
        }

        //把当前node放到链表头部
        ValueNode oldHead = head;
        node.pre = null;
        node.next = oldHead;

        oldHead.pre = node;
        head = node;

        if (tail == node) {
            tail = pre;
        }
    }

    public void put(int key, int value) {
        ValueNode oldNode = cache.get(key);
        if (oldNode != null) {
            oldNode.value = value;
            moveToHead(oldNode);
        } else {
            if (cache.size() == capacity) {
                //移除尾部节点
                ValueNode newTail = tail.pre;
                cache.remove(tail.key);
                if (newTail != null) {
                    newTail.next = null;
                }
                tail = newTail;
            }

            //往头部增加节点
            ValueNode node = new ValueNode(key, value);
            cache.put(key, node);

            ValueNode oldHead = head;
            if (oldHead != null) {
                oldHead.pre = node;
            }
            node.next = oldHead;
            head = node;
            if (tail == null) {
                tail = node;
            }
        }
    }

    private static class ValueNode {

        private final int key;

        private int value;

        private ValueNode next;

        private ValueNode pre;

        private ValueNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}