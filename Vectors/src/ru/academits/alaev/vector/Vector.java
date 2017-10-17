package ru.academits.alaev.vector;

import java.util.Arrays;

public class Vector {

    private double[] vector;


    public Vector(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("value of 'n' is negative: n = " + n + "");
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
        this.vector = Arrays.copyOf(array, n);
    }

    public double getElement(int i) {
        if (i > this.vector.length) {
            return 0;
        } else {
            return this.vector[i];
        }
    }


    public void setElement(int i, double element) {
        this.vector[i] = element;
    }

    public int getSize() {
        return this.vector.length;
    }

    public Vector getSum(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = Arrays.copyOf(this.vector, vector.vector.length);
            for (int i = 0; i < vector.vector.length; ++i) {
                this.vector[i] = this.vector[i] + vector.vector[i];
            }
            return this;
        } else {
            for (int i = 0; i < vector.vector.length; ++i) {
                this.vector[i] = this.vector[i] + vector.vector[i];
            }
            return this;
        }
    }

    public Vector getDifference(Vector vector) {
        if (this.vector.length < vector.vector.length) {
            this.vector = Arrays.copyOf(this.vector, vector.vector.length);
            for (int i = 0; i < vector.vector.length; ++i) {
                this.vector[i] = this.vector[i] - vector.vector[i];
            }
            return this;
        } else {
            for (int i = 0; i < vector.vector.length; ++i) {
                this.vector[i] = this.vector[i] - vector.vector[i];
            }
            return this;
        }
    }

    public void scalarMultiplication(double scalar) {
        for (int i = 0; i < this.vector.length; ++i) {
            this.vector[i] = this.vector[i] * scalar;
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
        return Arrays.toString(vector);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        if (vector1.getSize() > vector2.getSize()) {
            Vector newVector = new Vector(vector1.getSize(), vector1.vector);
            for (int i = 0; i < vector2.getSize(); ++i) {
                newVector.setElement(i, vector1.getElement(i) + vector2.getElement(i));
            }
            return newVector;
        } else {
            Vector newVector = new Vector(vector2);
            for (int i = 0; i < vector1.getSize(); ++i) {
                newVector.setElement(i, vector1.getElement(i) + vector2.getElement(i));
            }
            return newVector;
        }
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.getSize() < vector2.getSize()) {
            Vector newVector = new Vector(vector2.getSize(), vector1.vector);
            for (int i = 0; i < newVector.getSize(); ++i) {
                newVector.setElement(i, newVector.getElement(i) - vector2.getElement(i));
            }
            return newVector;
        } else {
            Vector newVector = new Vector(vector1.getSize(), vector1.vector);
            for (int i = 0; i < vector2.getSize(); ++i) {
                newVector.setElement(i, newVector.getElement(i) - vector2.getElement(i));
            }
            return newVector;
        }
    }

    public static double scalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        if (vector1.getSize() < vector2.getSize()) {
            for (int i = 0; i < vector1.getSize(); ++i) {
                scalarProduct += vector1.getElement(i) * vector2.getElement(i);
            }
            return scalarProduct;
        } else {
            for (int i = 0; i < vector2.getSize(); ++i) {
                scalarProduct += vector1.getElement(i) * vector2.getElement(i);
            }
            return scalarProduct;
        }
    }
}
