package com.lists;

import com.exceptions.EmptyListException;
import com.exceptions.InvalidPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SinglyLinkedListTest {
    SinglyLinkedList list = new SinglyLinkedList();

    void addElements(int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.list.insertLast("element " + (i + 1));
        }
    }

    @Test
    void SinglyLinkedList() {
        assertTrue(this.list instanceof SinglyLinkedList);
    }

    @Test
    void size() {
        assertEquals(this.list.size(), 0);
        addElements(2);
        assertEquals(this.list.size(), 2);
        addElements(2);
        assertEquals(this.list.size(), 4);
    }

    @Test
    void getHead() throws EmptyListException {
        assertNull(this.list.getHead());
        addElements(1);
        assertEquals(this.list.getHead().getElement(), this.list.get(0));
    }

    @Test
    void isEmpty() {
        assertTrue(this.list.isEmpty());
        addElements(1);
        assertFalse(this.list.isEmpty());
    }

    @Test
    void getFirst() throws EmptyListException {
        assertThrows(EmptyListException.class, () -> {
           this.list.getFirst();
        });
        this.addElements(5);
        assertEquals(this.list.getFirst(), "element 1");
    }

    @Test
    void getLast() throws EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            this.list.getLast();
        });
        this.addElements(5);
        assertEquals(this.list.getLast(), "element 5");
    }

    @Test
    void get() throws EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            this.list.get(0);
        });
        this.addElements(5);
        assertEquals(this.list.get(2), "element 3");
    }

    @Test
    void insertFirst() throws EmptyListException {
        this.list.insertFirst("element 1");
        assertEquals(this.list.getFirst(), "element 1");
        this.list.insertFirst("element 2");
        assertNotEquals(this.list.getFirst(), "element 1");
        assertEquals(this.list.getFirst(), "element 2");
    }

    @Test
    void insertLast() throws EmptyListException {
        this.list.insertFirst("element 1");
        assertEquals(this.list.getLast(), "element 1");
        this.addElements(3);
        assertNotEquals(this.list.getLast(), "element 1");
        this.list.insertLast("element");
        assertEquals(this.list.getLast(), "element");
    }

    @Test
    void insert() throws InvalidPositionException, EmptyListException {
        assertThrows(InvalidPositionException.class, () -> {
            this.list.insert("element ?", -1);
        });
        assertThrows(InvalidPositionException.class, () -> {
            this.list.insert("element ?", this.list.size()+1);
        });
        addElements(10);
        this.list.insert("element 0", 0);
        assertEquals(this.list.getFirst(), "element 0");
        addElements(10);
        this.list.insert("new element", 5);
        assertEquals(this.list.get(5), "new element");
        this.list.insert("last element", this.list.size());
        assertEquals(this.list.getLast(), "last element");
    }

    @Test
    void removerFirst() throws EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            this.list.removerFirst();
        });
        this.addElements(10);
        this.list.removerFirst();
        assertEquals(this.list.getFirst(), "element 2");
    }

    @Test
    void removeLast() throws EmptyListException {
        assertThrows(EmptyListException.class, () -> {
            this.list.removeLast();
        });
        this.addElements(10);
        this.list.removeLast();
        assertEquals(this.list.getLast(), "element 9");
    }

    @Test
    void remove() throws EmptyListException, InvalidPositionException {
        assertThrows(EmptyListException.class, () -> {
            this.list.remove(1);
        });
        this.addElements(10);
        assertThrows(InvalidPositionException.class, () -> {
            this.list.remove(10);
        });
        assertEquals(this.list.remove(5), "element 6");
        assertEquals(this.list.remove(0), "element 1");
        assertEquals(this.list.remove(7), "element 10");
    }

    @Test
    void iterator() {
        assertTrue(this.list.iterator() instanceof SinglyLinkedListIterator);
    }
}