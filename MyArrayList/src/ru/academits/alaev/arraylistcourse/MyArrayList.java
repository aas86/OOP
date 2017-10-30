package ru.academits.alaev.arraylistcourse;

import java.util.Arrays;

public class MyArrayList<T> {
    private T[] items = (T[]) new Object[2];
    private int length;

    public MyArrayList() {
    }

    public int getSize() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Несуществующий индекс");
        }
        return items[index];
    }

    public void set(int index, T object) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("Несуществующий индекс");
        }
        items[index] = object;
    }

    public void add(T object) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = object;
        ++length;
    }

    public void add(T object, int index) {
        length++;
        if (length >= items.length) {
            increaseCapacity();
        }
        for (int i = length - 1; i > index; --i) {
            items[i] = items[i - 1];
        }
        items[index] = object;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    public void remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Несуществующий индекс");
        }
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        --length;
    }

    public void remove(T object) {
        for (int i = 0; i < length; ++i) {
            if (items[i].equals(object)) {
                remove(i);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(items[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }
}
