package algs.deques_and_randomized_queues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node<Item> head;
    private int size = 0;

    public static void main(String[] args) {
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
        for (int i = 0; i < 10; i++) {
            randomizedQueue.enqueue(i);
        }
        for (Integer i : randomizedQueue) {
            System.out.println(i);
        }
        System.out.println(randomizedQueue.size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        size++;
        if (head == null) {
            head = new Node<>();
            head.data = item;
        } else {
            Node<Item> newNode = new Node<>();
            newNode.data = item;
            Node<Item> last = getLastNode();
            last.next = newNode;
            newNode.previous = last;
        }
    }

    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int rand = StdRandom.uniform(size());
        Node<Item> current = getNode(rand);
        Item data = current.data;

        Node<Item> prev = current.previous;
        Node<Item> next = current.next;
        size--;
        if (prev == null) {
            if (head.next != null) {
                head = head.next;
                head.previous = null;
            } else {
                head = null;
            }
        } else if (next == null) {
            Node<Item> temp = getLastNode();
            temp.previous.next = null;
        } else {
            prev.next = next;
            next.previous = prev;
        }

        return data;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int rand = StdRandom.uniform(size());
        Node<Item> current = getNode(rand);
        return current.data;
    }

    private void debug() {
        Node<Item> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private RandomizedQueue<Item> randomizedQueue;

        public QueueIterator() {
            randomizedQueue = new RandomizedQueue<>();
            Node<Item> temp = head;
            while (temp != null) {
                randomizedQueue.enqueue(temp.data);
                temp = temp.next;
            }
        }


        @Override
        public boolean hasNext() {
            return this.randomizedQueue.size != 0;
        }

        @Override
        public Item next() {
            return this.randomizedQueue.dequeue();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private Node<Item> getNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<Item> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private Node<Item> getLastNode() {
        Node<Item> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    private class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

    }


}