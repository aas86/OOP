package ru.academits.alaev;

import com.sun.org.apache.xpath.internal.SourceTree;
import ru.academits.alaev.vector.Vector;

public class Main {

    public static void main(String[] args) {

        Vector vectorA = new Vector(5);

        double[] array1 = new double[]{1, 2, 3, 4, 5, 6, 7};
        Vector vectorC = new Vector(array1);         // Вызов конструктора с массивом в качестве аргумента
        System.out.println("Вызов конструктора с массивом в качестве аргумента");
        System.out.println(vectorC);
        Vector vectorB = new Vector(vectorC);        // Вызов конструктора копирования
        System.out.println("Копируем предыдущий вектор");
        System.out.println(vectorB);

        double[] array2 = new double[]{1, 2, 3, 4, 5};
        Vector vectorD = new Vector(10, array2);
        System.out.println(vectorD.toString());

        // Проверка методов getSum() и getDifference
        System.out.println(vectorD.getSize());
        System.out.println(vectorA.getSize());

        double[] array3 = new double[]{1, 2, 3, 4, 5, 6};
        double[] array4 = new double[]{1, 2, 3};

        Vector a = new Vector(array3);
        Vector b = new Vector(array4);
        System.out.println(a);
        System.out.println(b);

        Vector c = b.getSum(a);
        System.out.println("Cумма векторов ");
        System.out.println(c);

        double[] array5 = new double[]{1, 2, 3, 4, 5, 6};
        double[] array6 = new double[]{1, 2, 3};
        Vector e = new Vector(array5);
        Vector f = new Vector(array6);
        Vector d = f.getDifference(e);

        System.out.println("Разность векторов ");
        System.out.println(d);

        System.out.println("Умножение вектора на скаляр ");
        System.out.println(f);
        f.scalarMultiplication(5);
        System.out.println(f);

        double[] array7 = new double[]{1, 2, 3};
        Vector g = new Vector(array7);
        System.out.println("Длина вектора " + g.getLength());

        // Проверка статических методов getSum() и getDifference();
        Vector x = new Vector(new double[]{1, 2, 3, 100});
        Vector y = new Vector(new double[]{1, 2, 3, });
        System.out.println(x);
        System.out.println(y);
    //  Vector z1 = Vector.getSum(x, y);
    //  System.out.println("Сумма векторов(static метод) " + z1);
    //  Vector z2 = Vector.getDifference(x, y);
    //  System.out.println("Разность векторов(static метод) " + z2);
        double scalarProduct = Vector.scalarProduct(x, y);
        System.out.println("Скалярное произведение векторов = " + scalarProduct);

        if (y.equals(x)) {
            System.out.println("Векторы " + x.toString() + " и " + y.toString() + " Равны");
        } else {
            System.out.println("Векторы " + x.toString() + " и " + y.toString() + " Не равны");
        }

        // Проверка hashCode() и equals();
        Vector m = new Vector(new double[]{1, 2, 3, 4});
        Vector n = new Vector(new double[]{1, 2, 3});
        if (m.hashCode() != n.hashCode()) {
            System.out.println("Хэши разные => объекты разные");
        } else if (m.equals(n)) {
            System.out.println("Объекты равны");
        }
        Vector zu = new Vector(new double[]{1, 2, 3});
        System.out.println(zu.getSize());
        zu.getElement(2);
        System.out.println(zu.toString());
    }
}

