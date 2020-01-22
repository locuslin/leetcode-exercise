package me.locus0;

import lombok.NoArgsConstructor;

import java.util.Comparator;

/**
 * Created on 2020/1/21.
 *
 * @author LingChuan
 */
public class BinarySearchTree<T extends Comparable<? super T>> {

    private Comparator<T> comparator = Comparator.naturalOrder();

    private Node<T> root = new Node<>();

    @NoArgsConstructor
    static class Node<T> {
        private Node<T> left;

        private Node<T> right;

        private T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void add(T e) {

        if (root == null) {
            root = new Node<>(e);
            return;
        }

        Node<T> cur = root;
        for (; ; ) {
            if (compare(e, cur.data) < 0) {
                if (cur.left == null) {
                    cur.left = new Node<>(e);
                    return;
                } else {
                    cur = cur.left;
                }
            } else {
                if (cur.right == null) {
                    cur.right = new Node<>(e);
                    return;
                } else {
                    cur = cur.right;
                }
            }
        }
    }

    int compare(T e1, T e2) {
        return comparator.compare(e1, e2);
    }

    public void remove(T e) {

    }

    public boolean contains(T e) {
        return false;
    }
}
