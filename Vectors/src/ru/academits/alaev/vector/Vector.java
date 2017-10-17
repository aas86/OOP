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
        this.vector = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) { // Нельзя создать нулевой вектор
            throw new IllegalArgumentException("value of 'n' is negative or: n = " + n + "");
        }
        this.vector = Arrays.copyOf(array, n);
    }

    public double getElement(int i) {
        if (i < 0 || i > this.vector.length) { //
            throw new IllegalArgumentException("value of 'i' is negative or out of range: i = " + i + "");
        } else {
            return this.vector[i];
        }
    }

    public void setElement(int i, double element) {
        if (i < 0 || i > this.vector.length) { //
            throw new IllegalArgumentException("value of 'i' is negative or out of range: i = " + i + "");
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
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i] = this.vector[i] * (-1);
        }
    }

    public double getLength() {
        double sum = 0;
        for (double e : this.vector) {
            sum += Math.pow(e, 2);
        }
        return Math.sqrt(sum);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double e : this.vector) {
            sb.append(e).append(" ,");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        return new Vector(vector1.getSum(vector2));
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        return new Vector(vector1.getDifference(vector2));
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        if (vector1.getSize() < vector2.getSize()) {
            for (int i = 0; i < vector1.getSize(); ++i) {
                scalarProduct += vector1.getElement(i) * vector2.getElement(i);
            }
        } else {
            for (int i = 0; i < vector2.getSize(); ++i) {
                scalarProduct += vector1.getElement(i) * vector2.getElement(i);
            }
        }
        return scalarProduct;
    }
}
