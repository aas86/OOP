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

        public MyListIterator() {
            this.currentIndex = 0;
        }

        public MyListIterator(int index) {
            this.currentIndex = index;
        }

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < length;
        }

        @Override
        public T next() {
            if (currentIndex + 1 >= length) {
                throw new NoSuchElementException();
            }
            return items[currentIndex + 1];
        }

        @Override
        public boolean hasPrevious() {
            return currentIndex - 1 >= 0;
        }

        @Override
        public T previous() {
            if (currentIndex - 1 < 0) {
                throw new NoSuchElementException();
            }
            return items[currentIndex - 1];
        }

        @Override
        public int nextIndex() {
            if (currentIndex == length - 1) {
                return length;
            } else {
                return currentIndex + 1;
            }
        }

        @Override
        public int previousIndex() {
            if (currentIndex == 0) {
                return -1;
            } else {
                return currentIndex - 1;
            }
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(currentIndex);
        }

        @Override
        public void set(T t) {
            items[currentIndex] = t;
        }

        @Override
        public void add(T t) {
            MyArrayList.this.add(currentIndex, t);
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
            if (currentIndex + 1 > length){
                throw new NoSuchElementException();
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

    // TODO
    @Override
    public ListIterator<T> listIterator() { // Не понял что это

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
        if (length >= items.length) {
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
 /*       if (object == null) {
            for (int i = 0; i < length; ++i) {
                if (this.get(i) == null) {
                    remove(i);
                    modCount++;
                    changesCount++;
                    break;
                }
            }
        } else {
            for (int i = 0; i < length; ++i) {
                if (object.equals(get(i))) {
                    remove(i);
                    modCount++;
                    changesCount++;
                    break;
                }
            }
        }*/
        for (int i = 0; i < length; ++i) {
            if (Objects.equals(items[i], object)) {
                remove(i);
                modCount++;
                changesCount++;
                break;
            }
        }
        return changesCount != 0;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int changesCount = 0;
      /*  for (Object element : collection) {
            if (element == null) {
                for (int i = 0; i < length; ++i) {
                    if (this.get(i) == null) {
                        this.remove(i);
                        changesCount++;
                        modCount++;
                        --i;
                    }
                }
            } else {
                for (int i = 0; i < length; ++i) {
                    if (element.equals(get(i))) {
                        this.remove(i);
                        --i;
                        changesCount++;
                        modCount++;
                    }
                }
            }
        }*/
        for (Object element : collection) {
            for (int i = 0; i < length; ++i) {
                if (Objects.equals(items[i], element)) {
                    this.remove(i);
                    --i;
                    changesCount++;
                    modCount++;
                }
            }
        }
        return changesCount != 0;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int changesCount = 0;
        for (int i = 0; i <= length; ++i) {
            if (!(collection.contains(items[i]))) {
                remove(items[i]);
                changesCount++;
                modCount++;
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


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int indexOf(Object object) {
       /* if (object == null) {
            for (int i = 0; i < length; ++i) {
                if (this.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < length; ++i) {
                if (object.equals(this.get(i))) {
                    return i;
                }
            }
        }*/
        for (int i = 0; i < length; ++i){
            if (Objects.equals(items[i], object)){
                return i;
            }
        }
            return -1;
    }


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int lastIndexOf(Object object) {
       /* if (object == null) {
            for (int i = length - 1; i >= 0; --i) {
                if (this.get(i) == null) {
                    return i;
                }
            }
        } else {
            for (int i = length - 1; i >= 0; --i) {
                if (object.equals(this.get(i))) {
                    return i;
                }
            }
        }*/
        for (int i = length - 1; i >= 0; --i){
            if (Objects.equals(items[i], object)){
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
}
