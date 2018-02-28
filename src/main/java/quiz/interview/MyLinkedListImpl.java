package quiz.interview;

import java.util.Arrays;

public class MyLinkedListImpl implements MyLinkedList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int elements[];

    public MyLinkedListImpl() {
        elements = new int[DEFAULT_CAPACITY];
    }

    @Override
    public void add(int element) {
        if (size == elements.length) {
            extendElementsSize();
        }
        elements[size] = element;
        size++;
    }

    @Override
    public int removeTail() {
        if (size == 0) {
            throw new IllegalStateException("list is empty");
        }

        int lastElement = elements[size-1];

        // remove last element
        elements = Arrays.copyOf(elements, elements.length - 1);
        size--;

        return lastElement;
    }

    @Override
    public void removeAllElementGreaterThan(int value) {
        removeFirstElementGreaterThan(value);
    }

    @Override
    public int getSize() {
        return size;
    }

    private void extendElementsSize() {
        int newSize = elements.length + DEFAULT_CAPACITY;
        elements = Arrays.copyOf(elements, newSize);
    }

    // Use recursive to remove value
    private void removeFirstElementGreaterThan(int value) {
        if (!isHasElementGreaterThan(value)) {
            return;
        }

        // remove fist element greater than value
        for (int i = 0; i < size; i++) {
            if (elements[i] > value) {
                for (int j = i; j < (elements.length - 1); j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                break;
            }
        }

        removeFirstElementGreaterThan(value);
    }

    private boolean isHasElementGreaterThan(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] >= value) {
                return true;
            }
        }

        return false;
    }
}
