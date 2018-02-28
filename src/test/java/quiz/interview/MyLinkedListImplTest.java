package quiz.interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListImplTest {

    @Test
    public void testSizeIncreaseWhenAddElement() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        assertTrue(linkedList.getSize() == 5);
    }

    @Test
    public void testRemoveTail() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        int value1 = linkedList.removeTail();
        assertTrue(value1 == 5);
        assertTrue(linkedList.getSize() == 4);

        int value2 = linkedList.removeTail();
        assertTrue(value2 == 4);
        assertTrue(linkedList.getSize() == 3);
    }

    @Test(expected=IllegalStateException.class)
    public void testRemoveTailWhenLinkListIsEmpty() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add(1);

        linkedList.removeTail();
        linkedList.removeTail(); // remove empty linkedlist
    }

    @Test
    public void testRemoveGreaterThanValue() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.add(6);
        linkedList.add(5);

        linkedList.removeAllElementGreaterThan(3);
        assertTrue(linkedList.getSize() == 2);

        int tail1 = linkedList.removeTail();
        assertTrue(tail1 == 1);

        int tail2 = linkedList.removeTail();
        assertTrue(tail2 == 2);
    }
}