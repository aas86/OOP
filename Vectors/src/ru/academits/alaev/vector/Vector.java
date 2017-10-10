package ru.academits.alaev.vector;

public class Vector {
    private int n;      //размерность вектора
    private double[] vector;
    private Vector clone;
    private double[] array;



    public Vector(int n) { // Конструктор вектора принимает число n – размерность вектора.
        this.n = n;
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vector) { // Конструктор копирования, т.е. по сути ссылочной переменной clone
                                   // присваивается ссылочная переменная vector. И теперь и vector, и clone
                                   // указывают на один и тот же массив из нулей.
        this.clone = vector;
    }

    public Vector(double[] array) { // передаю в конструктор массив и его же записываю в новый массив
        this.array = array;
    }

    public Vector(int n, double[] array) {

    }

}
