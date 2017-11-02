package ru.academits.alaev.arraylistcourse;


import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items = (T[]) new Object[5];
    private int length;

    public MyArrayList() {
    }

    private class MyIterator implements Iterator<T> {
        private int currentindex = -1;

        @Override
        public boolean hasNext() {
            return currentindex + 1 < length;
        }

        @Override
        public T next() {
            ++currentindex;
            return items[currentindex];
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        return null;
    }

    // TODO
    @Override
    public ListIterator<T> listIterator() { // Не понял что это

        return null;
    }


    @Override
    public Iterator<T> iterator() {         // Не понял что это
        return new MyIterator();
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < length; ++i) {
            if (items[i] == null) {
                continue;
            }
            if (items[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    @Override
    // Collection <?> => можно передать коллекцию любого типа, если бы Collection <Object>, то только object`ы. А так
    // Object и все его наследники, т.е. вообще что угодно.
    public boolean containsAll(Collection<?> collection) {

        for (Object element : collection) {
            if (!(this.contains(element))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public T get(int index) {
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        return items[index];
    }

    @Override
    public T set(int index, T object) { //Должен возвращать значение по индексу до замены
        if (index >= length || index < 0) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        T temp = items[index];
        items[index] = object;
        return temp;
    }

    @Override
    public boolean add(T object) {
        if (length >= items.length) {
            increaseCapacity();
        }
        items[length] = object;
        ++length;
        return true;
    }

    @Override
    public void add(int index, T object) {
        if (object == null) {
            throw new NullPointerException("Нельзя сюда NULL передевать!!!");
        }
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        length++;
        if (length >= items.length) {
            increaseCapacity();
        }
        for (int i = length - 1; i > index; --i) {
            items[i] = items[i - 1];
        }
        items[index] = object;
    }

    // TODO
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> list) {
        length = length + list.size();
        if (length >= items.length) {
            increaseCapacity();
        }
        System.arraycopy(items, index, items, index + list.size(), list.size());
        System.arraycopy(list, 0, items, index, list.size());
        return true;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        if (index < length - 1) {
            System.arraycopy(items, index + 1, items, index, length - index - 1);
        }
        --length;
        return items[index];
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            throw new NullPointerException("Нельзя сюда NULL передевать!!!");
        }
        for (int i = 0; i < length; ++i) {
            if (items[i] == null) {
                continue;
            }
            if (items[i].equals(object)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int count = 0;
        for (Object element : collection) {
            for (int i = 0; i < length; ++i) {
                if (this.items[i].equals(element)) {
                    this.remove(element);
                    count++;
                    --i;
                }
            }
        }
        return count != 0;
    }

    // TODO
    @Override
    public boolean retainAll(Collection<?> collection) {
        for (int i = 0; i < items.length; ++i) {
            for (Object element : collection) {
                if (items[i].equals(element)) {
                 break;
                }
            }
            this.remove(items[i]);
            i--;

        }
        return true;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[length];
        System.arraycopy(items, 0, array, 0, length);
        return array;
    }

    // TODO
    @Override
    public <T> T[] toArray(T[] a) {     //Не понял что метод делает и что возвращает и что вообще это такое <T> T[]
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < length; ++i) {
            sb.append(items[i]).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            throw new NullPointerException("Нельзя сюда NULL передевать!!!");
        }
        for (int i = 0; i < length; ++i) {
            if (items[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            throw new NullPointerException("Нельзя сюда NULL передевать!!!");
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (items[i] == null) {
                continue;
            }
            if (items[i].equals(o)) {
                index = i;
            }
        }
        return index;
    }
}
