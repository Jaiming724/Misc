package algs.deques_and_randomized_queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> head;
    private Node<Item> tail;
    private int size = 0;

    public Deque() {

    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("to chew bubblegum");
        deque.addLast("and");
        deque.addFirst("I'm here");
        deque.addLast("kick ass");
        for (String s : deque) {
            System.out.print(s + " ");
        }
        deque.removeFirst();
        deque.removeLast();
        deque.addLast("I'm all out of bubblegum");
        deque.removeFirst();
        System.out.println();
        for (String s : deque) {
            System.out.print(s + " ");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (head == null) {
            head = new Node<>();
            head.data = item;
            tail = head;
        } else {
            Node<Item> newNode = new Node<>();
            newNode.data = item;
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (tail == null) {
            tail = new Node<>();
            tail.data = item;
            head = tail;
        } else {
            Node<Item> newNode = new Node<>();
            newNode.data = item;
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }

    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Item item = head.data;
        if (head.next == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        size--;
        Item item = tail.data;
        if (tail.previous == null) {
            tail = null;
            head = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            Item item = current.data;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;
    }


}