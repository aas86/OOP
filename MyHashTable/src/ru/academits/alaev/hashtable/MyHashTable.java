package ru.academits.alaev.hashtable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;       // поле - массив ArrayList'ов
    private int elementsCount;              // общее количество элементов
    private int modCount;

    public MyHashTable() {
        //noinspection unchecked
        this.hashTable = new ArrayList[100];
    }

    public MyHashTable(int size) {
        //noinspection unchecked
        this.hashTable = new ArrayList[size];
    }

    private class MyHashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;
        private int listIndex = 0;
        private int indexInside = 0;

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
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
            T temp;
            for (int i = listIndex; i < hashTable.length; i++) {
                listIndex = i;
                if (hashTable[i] != null && hashTable[i].size() > 0) {
                    temp = hashTable[i].get(indexInside);
                    currentIndex++;
                    indexInside++;
                    if (indexInside == hashTable[i].size()) {
                        this.listIndex++;
                        this.indexInside = 0;
                    } else {
                        this.listIndex = i;
                    }
                    return temp;
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
        int i = Math.abs(o.hashCode() % hashTable.length);
        return hashTable[i] != null && hashTable[i].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return new MyHashTableIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[elementsCount];
        int i = 0;
        for (T element : this) {
            array[i] = element;
            i++;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int changesCount = 0;
        int i;
        if (t == null) {
            i = 0;
        } else {
            i = Math.abs(t.hashCode() % hashTable.length);
        }

        if (hashTable[i] == null) {
            hashTable[i] = new ArrayList<>();
        }
        this.hashTable[i].add(t);
        this.elementsCount++;
        changesCount++;
        modCount++;
        return changesCount != 0;
    }

    @Override
    public boolean remove(Object o) {
        int i = Math.abs(o.hashCode() % hashTable.length);
        if (hashTable[i] == null || hashTable[i].size() < 1) {
            return false;
        } else {
          /*  if (hashTable[i].contains(o)) {
                hashTable[i].remove(o);
                this.elementsCount--;
            }*/
            for (Iterator<T> iterator = hashTable[i].iterator(); iterator.hasNext(); ) {
                T element = iterator.next();
                if (Objects.equals(element, o)) {
                    iterator.remove();
                    this.elementsCount--;
                    modCount++;
                    break;
                }
            }
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
      /*  int count = 0;
        for (ArrayList<T> list : hashTable) {
            if (list != null) {
                for (Object e : c) {
                    if (list.contains(e)) {
                        count++;
                    }
                }
            }
        }
        return count != 0;*/
        for (Object e : c) {
            if (!this.contains(e)) {
                return false;
            }
        }
        return true;
    }

    @Override
    // В метод можно передать T и всех его наследников
    public boolean addAll(Collection<? extends T> c) {
        int changeCount = 0;
        for (T e : c) {
            this.add(e);
            changeCount++;
        }
        return changeCount == c.size();
    }

    @Override
    // В метод можно передать Object и всех его наследников, т.е. вообще всех
    public boolean removeAll(Collection<?> c) {
        int changeCount = 0;
        for (Object e : c) {
            int i = Math.abs(e.hashCode() % hashTable.length);
            if (hashTable[i] != null && hashTable[i].size() >= 1) {
                for (Iterator<T> iterator = hashTable[i].iterator(); iterator.hasNext(); ) {
                    T element = iterator.next();
                    if (Objects.equals(element, e)) {
                        iterator.remove();
                        this.elementsCount--;
                    }
                }
                changeCount++;
            }
        }
        return changeCount != 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int changeCount = 0;
        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (!c.contains(list.get(i))) {
                        list.remove(list.get(i));
                        elementsCount--;
                        i--;
                        changeCount++;
                    }
                }
            }
        }
        return changeCount != 0;
    }

    @Override
    public void clear() {
        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                list.clear();
                modCount++;
            }
        }
        elementsCount = 0;
    }

}
