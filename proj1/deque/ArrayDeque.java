package deque;

public class ArrayDeque<T> implements Deque<T> {
    protected T[] deque;
    protected int head;
    protected int tail;
    protected int size;

    // Initialize empty ArrayDeque
    public ArrayDeque() {
        deque = (T[]) new Object[8];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean isFull() {
        return (size == deque.length);
    }

    @Override
    public int size() {
        return size;
    }

    // Resize the Deque (*2) and reset the head, tail to 0, size -1
    private void resizeUp() {
        T[] newArray = (T[]) new Object[deque.length * 2];
        int sizeOfFirstCopy = deque.length - head;
        System.arraycopy(deque, head, newArray, 0, sizeOfFirstCopy);
        System.arraycopy(deque, 0, newArray, sizeOfFirstCopy, size - sizeOfFirstCopy);
        deque = newArray;
        head = 0;
        tail = size - 1;
    }

    // Resize the Deque to the original length (8)
    private void resizeDown() {
        deque = (T[]) new Object[8];
    }

    @Override
    // Adds an item from the front
    public void addFirst(T item) {
        if (isFull()) {
            resizeUp();
        }
        if (isEmpty()) {
            head = 0;
            tail = deque.length - 1;
        }
        head = (head - 1 + deque.length) % deque.length;
        deque[head] = item;

        size++;
    }

    @Override
    //Adds an item from the back
    public void addLast(T item) {
        if (isFull()) {
            resizeUp();
        }
        if (isEmpty()) {
            head = 0;
            tail = deque.length - 1;
        }
        tail = (tail + 1 + deque.length) % deque.length;
        deque[tail] = item;

        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Array is Empty");
        }
        T removedItem = deque[head];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1 + deque.length) % deque.length;
        }
        size--;
        return removedItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Array is Empty");
        }
        T removedItem = deque[tail];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            tail = (tail - 1 + deque.length) % deque.length;
        }
        size--;
        return removedItem;
    }

    @Override
    public T get(int index) {
        return deque[(head + index) % deque.length];
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    /*
    public int getSize() {
        if (isEmpty()) {
            return 0;
        }
        if (head <= tail) {
            return tail - head + 1;
        }
        return tail + size - head + 1;
    }

    public void printDeque() {
        int[] current = deque;
        for (int item : current) {
            System.out.println(item);
        }
    }

    // Adds an item from the front
    public void addFirst(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Array is Full");
        }
        if (isEmpty()) {
            head = 0;
            tail = size - 1;
        }
        head = (head - 1 + size) % size;
        deque[head] = item;
    }

    // Adds an item from the back
    public void addLast(int item) {
        if (isFull()) {
            throw new ArrayIndexOutOfBoundsException("Array is Full");
        }
        if (isEmpty()) {
            head = 0;
            tail = size - 1;
        }
        tail = (tail + 1 + size) % size;
        deque[tail] = item;
    }

    // Deletes an item from the front
    public void deleteFirst() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Array is Empty");
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1 + size) % size;
        }
    }

    // Deletes an item from the back
    public void deleteLast() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Array is Empty");
        }
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            tail = (tail - 1 + size) % size;
        }
    } */






}
