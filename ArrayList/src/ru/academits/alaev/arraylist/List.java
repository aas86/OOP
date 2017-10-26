package ru.academits.alaev.arraylist;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class List {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> a = new ArrayList<>();
        try (Scanner in = new Scanner(new FileInputStream("c:\\Users\\437-5\\IdeaProjects\\Repository\\ArrayList\\src\\ru\\academits\\alaev\\arraylist\\input.txt"))) {
            while (in.hasNextLine()) {
                a.add(in.nextLine());
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(4);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(5);
        System.out.println("Создали список" + list);

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                --i;
            }
        }
        System.out.println();
        System.out.println("Удалили все чётные числа" + list);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 11, 1, 5, 5, 1, 2, 2, 3));
        System.out.println(list1);

        ArrayList<Integer> newList = new ArrayList<Integer>(new LinkedHashSet<Integer>(list1));

        System.out.println(list1);
        System.out.println(newList);
    }
}
