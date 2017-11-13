package ru.academits.alaev;

public class ListItem <T>{
    private T data;
    private ListItem<T> next; // ссылка на следующий элемент, такого же типа

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }
    public ListItem(T data){
        this.data = data;
    }

    public ListItem() {
            }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }
}
