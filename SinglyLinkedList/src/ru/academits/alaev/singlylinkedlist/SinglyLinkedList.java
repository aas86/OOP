package ru.academits.alaev.singlylinkedlist;

import java.util.List;

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
    public T setElement(int index, ListItem<T> element) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                ListItem<T> temp = new ListItem<T>();
                temp.setData(p.getData());
                p.setData(element.getData());
                return temp.getData();
            }
            i++;
        }
        return null;
    }

    // 4. Получение узла по индексу
    public T getElement(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p.getData();
            }
            i++;
        }
        return null;
    }

    // 5. Удаление элемента по индексу, пусть выдает значение элемента(Удалённого?)
    public T delete(int index) {
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index - 1) {
                ListItem<T> q = p.getNext();
                p.setNext(q.getNext());
                this.size--;
                return q.getData();
            }
            i++;
        }
        return null;
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
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index - 1) {
                element.setNext(p.getNext());
                p.setNext(element);

                this.size++;
            }
            i++;
        }
    }

    // 8. Удаление узла по значению
    public void delete(ListItem<T> element) {
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (p == head) {
                if (p.getData().equals(element.getData())) {
                    deleteFirst();
                    break;
                }
            }
            ListItem<T> a = p.getNext();
            if (a.getData().equals(element.getData())) {
                p.setNext(a.getNext());
                size--;
                break;
            }

        }
    }

    // 9. Удаление первого элемента, пусть выдает значение элемента
    public T deleteFirst() {
        this.head = this.head.getNext();
        size--;
        return this.head.getData();
    }

    // 10 Вставка и удаление узла после указанного узла
    // 10.1 Вставка
    public void insertAfter(int index, ListItem<T> element) {
        if (index > size - 1 || index < 0) {
            throw new NullPointerException("Нет такого индекса");
        }
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                element.setNext(p.getNext());
                p.setNext(element);
                this.size++;
                break;
            }
            i++;
        }
    }

    //// 10.2 Удаление
    public void deleteAfter(int index) {
        if (index >= size - 1 || index < 0) {
            throw new NullPointerException("Нет элемента за указанным!");
        }
        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                ListItem<T> q = p.getNext();
                p.setNext(q.getNext());
                this.size--;
            }
            i++;
        }
    }

    // 11. Разворот
    public void reverse() {
        ListItem<T> temp = new ListItem<T>();
        for (ListItem<T> p = head; p != null; p = temp.getNext()) {
            while (p.getNext() != null) {
                temp.setNext(p.getNext().getNext());
                p.getNext().setNext(p);
                p.setNext(temp.getNext());
            }
        }

    }
}


