package ru.academits.alaev;

import ru.academits.alaev.vector.Vector;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Vector vectorA = new Vector(4);

        double[] array1 = new double[]{1, 2, 3, 4, 5, 6, 7};
        Vector vectorC = new Vector(array1);         // Вызов конструктора с массивом в качестве аргумента
        Vector vectorB = new Vector(vectorC);        // Вызов конструктора копирования

        double[] array2 = new double[]{1, 2, 3, 4, 5};
        Vector vectorD = new Vector(10, array2);

        System.out.println(vectorD.getSize());
        System.out.println(vectorA.getSize());
    }
}

