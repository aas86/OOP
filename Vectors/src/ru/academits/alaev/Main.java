package ru.academits.alaev;

import ru.academits.alaev.vector.Vector;

public class Main {

    public static void main(String[] args) {

     //   Vector vectorA = new Vector(4);

     //  Vector vectorB = new Vector(vectorA);  // Вызов конструктора копирования

        double[] a = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Vector vectorC = new Vector(a);

        /*
        double[] b = new double[]{1, 2, 3, 4, 5};
        Vector vector3 = new Vector(10, b);
        */
    }
}

