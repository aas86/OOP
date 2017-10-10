package ru.academits.alaev.vector;

public class Vector {

    private double[] vector;


    public Vector(int n) { // Конструктор вектора принимает число n – размерность вектора.
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vectorX) {   // Конструктор копирования принимает объект типа Vector
        this.vector = vectorX.vector;      // полю вектора B присваиваю поле ранее созданного вектора A
        this.vector = vectorX.getVector(); // Или вот так нужно
    }

    public Vector(double[] array) { // передаю в конструктор массив и его же записываю в новый массив
        this.vector = new double[array.length];
        for (int i = 0; i < array.length; ++i) {
            this.vector[i] = array[i];
        }
    }

    public Vector(int n, double[] array) {

    }

    private double[] getVector() {
        return vector;
    }

    private void setVector(double[] vector) {
        this.vector = vector;
    }

    public int getSize(Vector vector) {
        return vector.getVector().length;
    }
}
