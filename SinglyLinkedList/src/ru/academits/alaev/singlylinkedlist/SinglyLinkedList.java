package ru.academits.alaev.singlylinkedlist;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void beginInsert(ListItem<T> o) {
        ListItem<T> temp = head;
        this.head = o;
        o.setNext(temp);
        this.size++;
    }

    public T getFirstElement() {
        return head.getData();
    }

    public void deleteFirst() {
        this.head = this.head.getNext();
        size--;
    }

    public T getElement(int index) {
        if (index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        T element = null;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                element =  p.getData();
                break;
            }
            i++;
        }
        return element;
    }
}
