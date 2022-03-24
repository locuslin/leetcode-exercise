package me.locus0;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created on 2022/3/24/024.
 *
 * @author LingChuan
 */
@Slf4j
@Data
public class ReverseList {

    public void reverse(Node head) {
        if (head == null) {
            return;
        }
        doReverse(head);
        head.next = null;
    }

    private void doReverse(Node node) {
        Node next = node.next;
        if (next != null) {
            doReverse(next);
            next.next = node;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Node {
        private int value;
        private Node next;
    }

    public static void main(String[] args) {
        Node five = new Node(5, null);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        Node one = new Node(1, two);
        log.info("pre {}", one);
        new ReverseList().reverse(one);
        log.info("ret {}", five);
    }
}
