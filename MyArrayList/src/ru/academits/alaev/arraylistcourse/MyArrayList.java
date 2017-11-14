package ru.academits.alaev.arraylistcourse;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    @SuppressWarnings("unchecked")
    private T[] items = (T[]) new Object[5];
    private int length;
    private int modCount;

    public MyArrayList() {
    }

    private class MyListIterator implements ListIterator<T> {
        private int currentIndex;
        private int initialModCount = modCount;

        public MyListIterator() {
            this.currentIndex = 0;
        }

        public MyListIterator(int index) {
            this.currentIndex = index;
        }

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex + 1 < length;
        }

        @Override
        public T next() {
            if (currentIndex + 1 >= length) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            ++currentIndex;
            return items[currentIndex];
        }

        @Override
        public boolean hasPrevious() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex - 1 >= 0;
        }

        @Override
        public T previous() {
            if (currentIndex - 1 < 0) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            --currentIndex;
            return items[currentIndex];
        }

        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex);
            initialModCount = modCount;
        }

        @Override
        public void set(T t) {
            items[currentIndex] = t;
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(currentIndex, t);
            initialModCount = modCount;
        }
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex + 1 < length;
        }

        @Override
        public T next() {
            if (currentIndex + 1 > length) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            ++currentIndex;
            return items[currentIndex];
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
        return new MyListIterator(index);
    }

    @Override
    public ListIterator<T> listIterator() {

        return new MyListIterator();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    @Override
    public void clear() {
        length = 0;
    }

    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    @Override
    // Collection <?> => можно передать коллекцию любого типа, если бы Collection <Object>, то только object`ы. А так
    // Object и все его наследники, т.е. вообще что угодно.
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!this.contains(element)) {
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
        modCount++;
        return true;
    }

    @Override
    public void add(int index, T object) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index : " + index + " doesn't exists");
        }
        length++;
        if (length > items.length) {
            increaseCapacity();
        }
        System.arraycopy(items, index, items, index + 1, length - 1 - index);
        items[index] = object;
        modCount++;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int changesCount = 0;
        if (length + c.size() > items.length) {
            ensureCapacity(c.size() + length);
        }
        for (T element : c) {
            length++;
            items[length - 1] = element;
            changesCount++;
            modCount++;
        }
        return changesCount != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int changesCount = 0;
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }
        // 1. Увеличиваем массив, до нужной длины 1 раз
        if (length + c.size() > items.length) {
            ensureCapacity(length + c.size());
        }
        // 2. Раздвигаем исходный массив
        System.arraycopy(items, index, items, index + c.size(), length - index);
        length = length + c.size();
        // 3. На освободившееся место ставим элементы коллекции - аргумента
        int j = index;
        for (T e : c) {
            items[j] = e;
            j++;
            changesCount++;
            modCount++;
        }
        return changesCount != 0;
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
        modCount++;
        return items[index];
    }

    @Override
    public boolean remove(Object object) {
        int changesCount = 0;
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(items[i], object)) {
                remove(i);
                changesCount++;
                break;
            }
        }
        return changesCount != 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int changesCount = 0;
        for (Object element : collection) {
            for (int i = 0; i < length; ++i) {
                if (Objects.equals(items[i], element)) {
                    this.remove(i);
                    --i;
                    changesCount++;
                }
            }
        }
        return changesCount != 0;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int changesCount = 0;
        for (int i = 0; i < length; ++i) {
            if (!collection.contains(items[i])) {
                remove(items[i]);
                changesCount++;
                i--;
            }

        }
        return changesCount != 0;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        System.arraycopy(items, 0, array, 0, length);
        return array;
    }

    @Override
    // В качестве аргумента передаётся массив, в который нужно сложить коллекцию, от которой вызван метод. Если длины
    // массива-аргумента не достаточно, то выделить новый массив, с типом, как у массива-аргумента и размерностью списка (1 случай)
    // Если массив - аргумент больше списка, то положить список в массив - аргумент, а недостающие заполнить null (2)
    // Это дженерик метод, только вот зачем это всё не понимаю.
    public <E> E[] toArray(E[] a) {
        /*1.*/
        if (a.length < length) {
            // Make a new array of a's runtime type, but my contents:
            //noinspection unchecked
            return (E[]) Arrays.copyOf(items, length, a.getClass());
        }
        /*2*/
        System.arraycopy(items, 0, a, 0, length);
        if (a.length > length) {
            a[length] = null;
        }
        return a;
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


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }
        return -1;
    }


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; --i) {
            if (Objects.equals(items[i], object)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacity(int length) {
        if (this.length < length) {
            items = Arrays.copyOf(items, length);
        }
    }

    private void trimToSize() {
        if (items.length > length) {
            items = Arrays.copyOf(items, length);
        }
    }
}
