package ru.academits.alaev.hashtable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyHashTable<T> implements Collection<T> {
    private int size;
    private ArrayList<T>[] hashTable;

    public MyHashTable(){

    }
    public MyHashTable(int size) {
        this.size = size;
        this.hashTable = new ArrayList[size];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
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
            changesCount++;
        } else {
            this.hashTable[i].add(t);
            changesCount++;
        }
        return changesCount != 0;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
