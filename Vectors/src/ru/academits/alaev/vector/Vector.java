package ru.academits.alaev.vector;

public class Vector {

    private double[] vector;


    public Vector(int n) { // Конструктор вектора принимает число n – размерность вектора.
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vector) {   // Конструктор копирования принимает объект типа Vector
        this.vector = vector.getVector();

    }

    public Vector(double[] array) { // передаю в конструктор массив и его же записываю в новый массив
        setVector(array);
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
