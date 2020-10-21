package com.lists;

import com.exceptions.NoSuchElementException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListIteratorTest {

    @Test
    void hasNext() throws NoSuchElementException {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedListIterator it = list.iterator();
        assertFalse(it.hasNext());
        list.insertLast("element 1");
        list.insertLast("element 2");
        list.insertLast("element 3");
        it = list.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    void next() throws NoSuchElementException {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedListIterator it = list.iterator();
        SinglyLinkedListIterator finalIt = it;
        assertThrows(NoSuchElementException.class, () -> {
            finalIt.next();
        });
        list.insertLast("element 1");
        list.insertLast("element 2");
        list.insertLast("element 3");
        it = list.iterator();
        assertEquals(it.next(), "element 1");
        assertEquals(it.next(), "element 2");
        assertEquals(it.next(), "element 3");
        SinglyLinkedListIterator finalIt1 = it;
        assertThrows(NoSuchElementException.class, () -> {
            finalIt1.next();
        });
    }

    @Test
    void rewind() throws NoSuchElementException {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertLast("element 1");
        list.insertLast("element 2");
        SinglyLinkedListIterator it = list.iterator();
        assertEquals(it.next(), "element 1");
        assertEquals(it.next(), "element 2");
        it.rewind();
        assertEquals(it.next(), "element 1");
    }
}