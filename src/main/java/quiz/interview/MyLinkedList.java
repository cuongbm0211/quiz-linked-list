package quiz.interview;

public interface MyLinkedList {
    void add(int element);

    int removeTail();

    void removeAllElementGreaterThan(int value);

    int getSize(); // Use for test class
}
