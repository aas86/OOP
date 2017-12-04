package ru.academits.alaev.binarysearchtree;

import java.util.Comparator;

public class NodesComparator<T> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }
    }
}
