package ru.academits.alaev.arraylist;

import java.util.ArrayList;
import java.util.Arrays;

public class List {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println("Удалили все чётные числа");
        System.out.println(list);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 5,5,1, 2, 2, 2, 2, 1, 3, 1, 3, 3));
        // ArrayList<Integer> newList = new ArrayList<>();
        System.out.println(list1);
        // newList.add(list1.get(0));
        for (int i = 0; i < list1.size() - 1; ++i) {
            for (int j = i + 1; j < list1.size(); j++) {
                if (list1.get(j).equals(list1.get(i))) {
                    list1.remove(j);
                    --j;
                }
            }
        }
        System.out.println(list1);
        // System.out.println(newList);
    }
}
