package deque;

import java.util.Comparator;
public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    // Create a MaxArrayDeque with the given Comparator
    public MaxArrayDeque(Comparator<T> c) { // ex. new MaxArrayDeque<>(Comparator.naturalOrder());
        super();
        this.comparator = c;
    }

    // Returns the maximum element in the deque as governed by the previously given Comparator.
    public T max() {
        if (isEmpty()) {
            return null;
        }

        T maxElement = deque[head];
        for (int i = (head + 1) % deque.length; i != (tail + 1) % deque.length; i = (i + 1) % deque.length) {
            if (comparator.compare(deque[i], maxElement) > 0) {
                maxElement = deque[i];
            }
        }
        return maxElement;
    }

    //returns the maximum element in the deque as governed by the parameter Comparator c.
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }

        T maxElement = deque[head];
        for (int i = (head + 1) % deque.length; i != (tail + 1) % deque.length; i = (i + 1) % deque.length) {
            if (c.compare(deque[i], maxElement) > 0) {
                maxElement = deque[i];
            }
        }
        return maxElement;
    }


}
