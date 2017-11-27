package ru.academits.alaev.hashtable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;       // поле - массив ArrayList'ов
    private int elementsCount;              // общее количество элементов
    private int modCount;

    public MyHashTable() {
        this.hashTable = new ArrayList[10];
    }

    public MyHashTable(int size) {
        this.hashTable = new ArrayList[size];
    }

    private class MyHashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            //for (int i = 0; i < hashTable.length; i++) {
            //    while (hashTable[i] == null) {
            //         ++i;
            //     }
            //  for (Iterator<T> j = hashTable[i].iterator(); j.hasNext(); ) {
            //    return currentIndex + 1 < elementsCount;
            //  }
            // }
            return currentIndex + 1 < elementsCount;
        }

        @Override
        public T next() {
            if (currentIndex + 1 > hashTable.length) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            for (int i = 0; i < hashTable.length; i++) {
                if (hashTable[i] != null) {
                    currentIndex++;
                    Iterator<T> j = hashTable[i].iterator();
                    while (j.hasNext()) {

                        return j.next();
                    }
                }
            }
            return null;
        }
    }

    @Override
    public int size() {
        return elementsCount;
    }

    // Проверяем именно наличие элементов в списках, а не наличие списков.
    @Override
    public boolean isEmpty() {
        return elementsCount == 0;
    }

    @Override
    public boolean contains(Object o) {
        int i = o.hashCode();
        return hashTable[i] != null && hashTable[i].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int changesCount = 0;
        int i = t.hashCode();
        if (hashTable[i] == null) {
            hashTable[i] = new ArrayList<T>();
            hashTable[i].add(t);
            this.elementsCount++;
            changesCount++;
            modCount++;
        } else {
            this.hashTable[i].add(t);
            this.elementsCount++;
            changesCount++;
            modCount++;
        }
        return changesCount != 0;
    }

    @Override
    public boolean remove(Object o) {
        int i = o.hashCode();
        if (hashTable[i] == null) {
            return false;
        } else {
            // Нельзя менять коллекцию при проходе по итератору
          /*  for (Object e : hashTable[i]) {
                if (o.equals(e)) {
                    hashTable[i].remove(o);
                    this.elementsCount--;
                }
            }*/

            for (Iterator<T> iterator = hashTable[i].iterator(); iterator.hasNext(); ) {
                T element = iterator.next();
                if (Objects.equals(element, o)) {
                    iterator.remove();
                    this.elementsCount--;
                }
            }
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        Object[] arr = c.toArray();
        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                for (Object e : arr) {
                    if (list.contains(e)) {
                        count++;
                    }
                }
            }
        }
        return count == arr.length;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int count = 0;
        Object[] arr = c.toArray();
        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                for (Object e : arr) {
                    if (list.contains(e)) {
                        list.remove(e);
                        count++;
                    }
                }
            }
        }
        return count == arr.length;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
