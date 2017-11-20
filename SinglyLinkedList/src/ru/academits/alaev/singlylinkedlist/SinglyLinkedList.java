package ru.academits.alaev.singlylinkedlist;

import java.io.IOException;
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
    public T setElement(int index, ListItem<T> element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом!");
        }
        T temp = getNode(index).getData();
        getNode(index).setData(element.getData());
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
    public T delete1(int index) {
        if (index == 0) {
            throw new IndexOutOfBoundsException("Есть отдельный метод для удаления первого элемента коллекции");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Нет элемента с таким индексом");
        }
        // ListItem<T> p = getNode(index - 1);
        ListItem<T> q = getNode(index - 1).getNext();
        getNode(index - 1).setNext(q.getNext());
        this.size--;
        return q.getData();
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
        element.setNext(getNode(index - 1).getNext());
        getNode(index - 1).setNext(element);
        this.size++;
    }

    // 8. Удаление узла по значению
    public boolean delete(ListItem<T> element) {
        if (element.getData() == head.getData()) {
            deleteFirst();
            return true;
        }
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            ListItem<T> q = p.getNext();
            if (/*q.getData() == element.getData()*/ Objects.equals(q.getData(), element.getData())) {
                p.setNext(q.getNext());
                size--;
                return true;
            }
        }
        return false;
    }

    // 9. Удаление первого элемента, пусть выдает значение элемента
    public T deleteFirst() {
        if (head == null){
            throw new IndexOutOfBoundsException("Коллекция пустая!");
        }
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
        element.setNext(getNode(index).getNext());
        getNode(index).setNext(element);
        this.size++;
    }

    //// 10.2 Удаление
    public void deleteAfter(int index) {
        if (index >= size - 1 || index < 0) {
            throw new NullPointerException("Нет элемента за указанным!");
        }
        ListItem<T> q = getNode(index).getNext();
        getNode(index).setNext(q.getNext());
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


