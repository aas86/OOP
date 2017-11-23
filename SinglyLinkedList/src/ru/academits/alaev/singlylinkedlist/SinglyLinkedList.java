package ru.academits.alaev.singlylinkedlist;

import java.util.Objects;

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

    // 1. Получение размера списка
    public int getSize() {
        return size;
    }

    // 2. Получение первого узла
    public T getFirstElement() {
        return head.getData();
    }

    // 3. Изменение значения по индексу пусть выдает старое значение.
    public T setElement(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом!");
        }
        ListItem<T> p = getNode(index);
        T temp = p.getData();
        p.setData(element);
        return temp;
    }

    // 4. Получение узла по индексу
    public T getElement(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом!");
        }
        return getNode(index).getData();
    }

    // 5. Удаление элемента по индексу, пусть выдает значение элемента(Удалённого?)
    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом");
        }
        if (index == 0) {
            return deleteFirst();
        } else {
            ListItem<T> p = getNode(index - 1);
            ListItem<T> q = p.getNext();
            p.setNext(q.getNext());
            this.size--;
            return q.getData();
        }
    }

    // 6. Вставка элемента в начало
    public void beginInsert(ListItem<T> o) {
        ListItem<T> temp = head;
        this.head = o;
        o.setNext(temp);
        this.size++;
    }


    // 7. вставка элемента по индексу
    public void insertElement(int index, ListItem<T> element) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом");
        }
        ListItem<T> p = getNode(index - 1);
        element.setNext(p.getNext());
        p.setNext(element);
        this.size++;
    }

    // 8. Удаление узла по значению
    public boolean delete(T element) {
        if (Objects.equals(element, head.getData())) {
            deleteFirst();
            return true;
        }
        for (ListItem<T> p = head, q = p.getNext(); q != null; p = p.getNext(), q = p.getNext()) {
            if (Objects.equals(q.getData(), element)) {
                p.setNext(q.getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    // 9. Удаление первого элемента, пусть выдает значение элемента
    public T deleteFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException("Коллекция пустая!");
        }
        T temp = this.head.getData();
        this.head = this.head.getNext();
        size--;
        return temp;
    }

    // 10 Вставка и удаление узла после указанного узла
    // 10.1 Вставка
    public void insertAfter(int index, ListItem<T> element) {
        if (index > size - 1 || index < 0) {
            throw new NullPointerException("Нет такого индекса");
        }
        ListItem<T> p = getNode(index);
        element.setNext(p.getNext());
        p.setNext(element);
        this.size++;
    }

    //// 10.2 Удаление
    public void deleteAfter(int index) {
        if (index >= size - 1 || index < 0) {
            throw new NullPointerException("Нет элемента за указанным!");
        }
        ListItem<T> p = getNode(index);
        ListItem<T> q = p.getNext();
        p.setNext(q.getNext());
        this.size--;
    }

    // 11. Разворот
    public void reverse() {
        ListItem<T> temp;// = new ListItem<>();
        for (ListItem<T> p = head, prev = null; p != null; prev = p, p = temp) {
            temp = p.getNext();
            p.setNext(prev);
            head = p;
        }
    }

    private ListItem<T> getNode(int index) {
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }
            i++;
        }
        return head; // Тут возвращаю head, только потому, что надо что-то вернуть, если null, то warning'и!
    }
}


