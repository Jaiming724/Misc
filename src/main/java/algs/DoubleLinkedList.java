package algs;


import java.util.Iterator;
import java.util.Objects;

public class DoubleLinkedList<T> implements Iterable<T> {
    private Node<T> head = new Node<>();
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }


    public void add(T ele) {
        size++;
        //Check if it is the first element of the list
        if (head.data == null) {
            head.data = ele;
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.data = ele;
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.previous = current;
    }


    public void remove(T ele) {
        Node<T> current = head;

        //loop through the list to find the one that matches
        while (current != null) {
            if (current.data.equals(ele)) {
                Node<T> prev = current.previous;
                Node<T> next = current.next;

                //if the wanted element is the head element
                if (prev == null) {
                    head = current.next;
                } else {
                    prev.next = next;
                }

                //ensure the wanted element is not the tail element
                if (next != null) {
                    next.previous = prev;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public T get(int index) {
        return getNode(index).data;
    }

    public void insert(T element, int index) {
        Node<T> current = getNode(index);
        //check if the wanted element is the first element
        if (current == null) {
            current.data = element;
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.data = element;

        //check if the insertion is on the head element
        if (current.previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.previous = current.previous;
            current.previous.next = newNode;
            newNode.next = current;
        }

    }

    private Node<T> getNode(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void debug() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    private class DoubleLinkedListIterator implements Iterator<T> {

        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public T next() {
            T item = current.data;
            current = current.next;
            return item;
        }
    }

    private class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(previous, node.previous) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, previous, next);
        }
    }
}
