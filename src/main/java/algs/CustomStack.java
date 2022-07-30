package algs;

public class CustomStack<E> {

    private E[] stack;
    private int size;
    private int maxSize = 2;

    public CustomStack() {
        stack = (E[]) new Object[maxSize];
    }

    public int size() {
        return size;
    }

    public void push(E element) {
        if (size == maxSize) {
            System.out.println("Resizing array from " + maxSize + " to " + maxSize* 2);
            resize(maxSize * 2);
            maxSize *= 2;
        }
        stack[size] = element;
        size++;
    }

    public E pop() throws IllegalStateException {
        if (size == 0 || stack[size - 1] == null) {
            throw new IllegalStateException("Stack is empty");
        }
        E ele = stack[size - 1];
        stack[size - 1] = null;
        size--;

        if (size > 0 && size <= stack.length / 4) {
            System.out.println("Resizing array from " + stack.length + " to " + stack.length / 2);
            resize(stack.length / 2);
            maxSize = stack.length / 2;
        }
        return ele;
    }

    public E peek() throws IllegalStateException {
        if (size == 0 || stack[size - 1] == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[size - 1];
    }

    public boolean clear() {
        maxSize = 4;
        stack = (E[]) new Object[maxSize];
        size = 0;
        return true;
    }

    public boolean contains(E elem) {
        for (int i = 0; i < size; i++) {
            if (stack[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    private void resize(int n) {
        E[] temp = (E[]) new Object[n];
        for (int i = 0; i < size; i++) {
            temp[i] = stack[i];
        }
        stack = temp;
    }
}