package com.lists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleListNodeTest {

    @Test
    void SingleListNode() {
        assertTrue(new SingleListNode("element", null) instanceof SingleListNode);
    }

    @Test
    void getElement() {
        SingleListNode first_node = new SingleListNode("element 1", null);
        assertEquals(first_node.getElement(), "element 1");
    }

    @Test
    void getNext() {
        SingleListNode second_node = new SingleListNode("element 2", null);
        SingleListNode first_node = new SingleListNode("element 1", second_node);
        assertEquals(first_node.getNext(), second_node);
    }

    @Test
    void setNext() {
        SingleListNode first_node = new SingleListNode("element 1", null);
        SingleListNode second_node = new SingleListNode("element 2", null);
        assertNotEquals(first_node.getNext(), second_node);
        first_node.setNext(second_node);
        assertEquals(first_node.getNext(), second_node);
    }
}