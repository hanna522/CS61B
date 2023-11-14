package deque;

/** Need to check public/private */
public class LinkedListDeque <T> implements Deque<T> {
    private class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(TNode p, T x, TNode n) {
            prev = p;
            item = x;
            next = n;
        }
    }

    private TNode sentinel; // sentinel 은 링크드 리스트의 시작과 끝을 나타내는 가상의 노드
    private int size;

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    // Adds an item of type T to the back of the deque. Assume item is never null.
    @Override
    public void addLast(T item) {
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    // Removes and returns the item at the front of the deque. if no such item exists, returns null.
    public T removeFirst() {
        if (sentinel.next.item == null) {
            return null;
        } else {
            T removedItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return removedItem;
        }
    }

    @Override
    // Removes and returns the item at the back of the deque. if no such item exists, returns null.
    public T removeLast() {
        if (sentinel.prev.item == null) {
            return null;
        } else {
            T removedItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return removedItem;
        }
    }

    @Override
    // Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such Item exists, return null.
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        TNode current = sentinel.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.item;
    }

    // Sames as get, but uses recursion
    public T getRecursion(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bound: " + index);
        }
        return recursionHelper(sentinel.next, index);
    }
    private T recursionHelper(TNode current, int index) {
        if (index == 0) {
            return current.item;
        }
        return recursionHelper(current.next, index - 1);
    }

    // Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
    public void printDeque() {
        TNode ptr = sentinel;
        while (ptr.next != sentinel) {
            ptr = ptr.next;
            System.out.print(ptr.item);
            System.out.print(" ");
        }
        System.out.println();
    }

}