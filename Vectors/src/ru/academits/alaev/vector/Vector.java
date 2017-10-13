package ru.academits.alaev.vector;

public class Vector {

    private double[] vector;


    public Vector(int n) { // Конструктор вектора принимает число n – размерность вектора.
        if (n < 0) {
            throw new IllegalArgumentException("value of 'n' is negative: n = " + n + "");
        }
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vector) {   // Конструктор копирования принимает объект типа Vector
        // Т.к. поле vector не определено (NULL), то нельзя взять его длину, но длину можно взять из принятого объекта,
        // который является тоже массивом с полем length. Эта длина будет 5ым аргументом метода arraycopy() Для того,
        // чтобы получить эту длину прохожусь по всему массиву и считаю кол-во элементов.
        this.vector = new double[vector.vector.length];
        System.arraycopy(vector.vector, 0, this.vector, 0, vector.vector.length);
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

    public double getVectorElement(int i) {
        return this.vector[i];
    }


    public void setVectorElement(int i, double element) {
        this.vector[i] = element;
    }

    public int getSize() {
        return this.vector.length;
    }

    public String toString() {
        char[] ch = new char[vector.length];
        for (int i = 0; i < this.vector.length; ++i) {
            ch[i] = (char) this.vector[i];
        }
        return new String(ch);
    }

    public Vector getSum(Vector vector) {
        if (this.vector.length > vector.vector.length) {
            Vector newVector = new Vector(this.vector);
            for (int i = 0; i < vector.vector.length; ++i) {
                newVector.vector[i] = this.vector[i] + vector.vector[i];
            }
            return newVector;
        } else if (this.vector.length < vector.vector.length) {
            Vector newVector = new Vector(vector.vector);
            for (int i = 0; i < this.vector.length; ++i) {
                newVector.vector[i] = this.vector[i] + vector.vector[i];
            }
            return newVector;
        } else {
            Vector newVector = new Vector(this.vector.length);
            for (int i = 0; i < this.vector.length; ++i) {
                newVector.vector[i] = this.vector[i] + vector.vector[i];
            }
            return newVector;
        }
    }

    public Vector getDifference(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            Vector newVector = new Vector(vector.vector.length, this.vector);
            for (int i = 0; i < newVector.vector.length; ++i) {
                newVector.vector[i] = newVector.vector[i] - vector.vector[i];
            }
            return newVector;
        } else if (this.vector.length > vector.vector.length) {
            Vector newVector = new Vector(this.vector.length, vector.vector);
            for (int i = 0; i < newVector.vector.length; ++i) {
                newVector.vector[i] = this.vector[i] - newVector.vector[i];
            }
            return newVector;
        } else {
            Vector newVector = new Vector(this.vector.length);
            for (int i = 0; i < this.vector.length; ++i) {
                newVector.vector[i] = this.vector[i] - vector.vector[i];
            }
            return newVector;
        }
    }
}
