package ru.academits.alaev.vector;

public class Vector {

    private double[] vector;


    public Vector(int n) { // Конструктор вектора принимает число n – размерность вектора.
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vector) {   // Конструктор копирования принимает объект типа Vector
        // Т.к. поле vector не определено (NULL), то нельзя взять его длину, но длину можно взять из принятого объекта,
        // который является тоже массивом с полем length. Эта длина будет 5ым аргументом метода arraycopy() Для того,
        // чтобы получить эту длину прохожусь по всему массиву и считаю кол-во элементов.
        int length = 1;
        for (int i = 0; i < vector.vector.length - 1; i++) {
            length++;
        }
        this.vector = new double[length];
        System.arraycopy(vector.vector, 0, this.vector, 0, length);
        // из поля принятого вектора положить в поле vector. Именно не ссылку, а поэлементно. (arraycopy() заменяет
        // проход по массиву циклом)
    }

    public Vector(double[] array) { // передаю в конструктор массив и его же записываю в новый массив
        this.vector = new double[array.length];
        System.arraycopy(array, 0, this.vector, 0, array.length);
    }

    public Vector(int n, double[] array) {
        this.vector = new double[n];
        System.arraycopy(array, 0, this.vector, 0, array.length);
    }

    public double[] getVector() {
        return vector;
    }

    public void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getSize() {
        return this.vector.length;
    }
}
