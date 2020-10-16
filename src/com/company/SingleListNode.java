package com.company;

public class SingleListNode {
    private Object element;
    private SingleListNode nextNode;

    SingleListNode(Object element, SingleListNode nextNode) {
        this.element = element;
        setNext(nextNode);
    }

    public Object getElement() {
        return this.element;
    }

    public SingleListNode getNext() {
        return this.nextNode;
    }

    public void setNext(SingleListNode node) {
        this.nextNode = node;
    }

}
