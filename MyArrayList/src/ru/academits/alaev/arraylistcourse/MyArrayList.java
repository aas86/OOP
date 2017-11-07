package ru.academits.alaev.arraylistcourse;


import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items = (T[]) new Object[5];
    private int length;
    private int modCount;

    public MyArrayList() {
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
        if (length + c.size() >= items.length) {
            ensureCapacity(c.size() + length);
        }
        for (T element : c) {
            length++;
            items[length - 1] = element;
            changesCount++;
        }
        return changesCount != 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> list) {
        length = length + list.size();
        if (length >= items.length) {
            increaseCapacity();
        }
        for (Object e : list) {
            int j = index;
            for (int i = index; i < index + list.size(); ++i) {
                items[i + list.size()] = items[i];
                this.set(j, (T) e);
                break;
            }
            index = index + 1;
        }
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
        modCount++;
        return items[index];
    }

    @Override
    public boolean remove(Object object) {
        if (object == null) {
            this.remove(this.indexOf(null));
        }
        for (int i = 0; i < length; ++i) {
            if (items[i].equals(object)) {
                remove(i);
                modCount++;
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

    @Override
    public boolean retainAll(Collection<?> collection) {
        for (Object element : collection) {
            for (int i = 0; i < length; ++i) {
                if (!(collection.contains(this.items[i]))) {
                    this.remove(items[i]);
                }
            }
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


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int indexOf(Object object) {
        if (object == null) {
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
        }
        return -1;
    }


    //(o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
    @Override
    public int lastIndexOf(Object object) {
        if (object == null) {
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
        }
        return -1;
    }

    private void ensureCapacity(int length) {
        items = Arrays.copyOf(items, length);
    }
}
