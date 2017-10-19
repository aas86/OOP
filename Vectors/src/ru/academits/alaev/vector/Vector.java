package ru.academits.alaev.vector;

import java.util.Arrays;

public class Vector {

    private double[] vector;


    public Vector(int n) {
        if (n <= 0) { // Нельзя создать нулевой вектор
            throw new IllegalArgumentException("value of 'n' is negative or 0: n = " + n + "");
        }
        this.vector = new double[n]; // По умолчанию создаётся массив 0 размерности n
    }

    public Vector(Vector vector) {
        this.vector = Arrays.copyOf(vector.vector, vector.vector.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Value of 'n' is negative or 0: n = " + array.length + "");
        }

        this.vector = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) { // Нельзя создать нулевой вектор
            throw new IllegalArgumentException("Value of 'n' is negative or: n = " + n + "");
        }
        this.vector = Arrays.copyOf(array, n);
    }

    public double getElement(int i) {
        if (i < 0 || i >= this.vector.length) { //
            throw new IndexOutOfBoundsException("Value of 'i' is negative or out of bound : i = " + i + "");
        } else {
            return this.vector[i];
        }
    }

    public void setElement(int i, double element) {
        if (i < 0 || i >= this.vector.length) { //
            throw new IndexOutOfBoundsException("Value of 'i' is negative or out of bound: i = " + i + "");
        } else {
            this.vector[i] = element;
        }
    }

    public int getSize() {
        return this.vector.length;
    }

    public Vector getSum(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = Arrays.copyOf(this.vector, vector.vector.length);
        }
        for (int i = 0; i < vector.vector.length; ++i) {
            this.vector[i] = this.vector[i] + vector.vector[i];
        }
        return this;
    }

    public Vector getDifference(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = Arrays.copyOf(this.vector, vector.vector.length);
        }
        for (int i = 0; i < vector.vector.length; ++i) {
            this.vector[i] = this.vector[i] - vector.vector[i];
        }
        return this;
    }


    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i] = this.vector[i] * scalar;
        }
    }

    public void rotate() {
        this.scalarMultiplication(-1);
    }

    public double getLength() {
        double sum = 0;
        for (double e : this.vector) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double e : this.vector) {
            sb.append(e).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        return prime * Arrays.hashCode(this.vector);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {   // Если объект сравниваем сам с собой
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            // Если объекты принадлежат разным классам
            // т.к. не статик метод, то вызываем обязательно от какого-то объекта, а значит он уже не null
            return false;
        }
        Vector v = (Vector) o; // Приводим тип объекта аргумента к классу с которым сравниваем
        return (v.vector.length == this.vector.length && Arrays.equals(this.vector, v.vector));
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        return new Vector(newVector.getSum(vector2));
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        return newVector.getDifference(vector2);
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        for (int i = 0; i < Math.min(vector1.vector.length, vector2.vector.length); ++i) {
            scalarProduct += vector1.getElement(i) * vector2.getElement(i);
        }
        return scalarProduct;
    }
}
